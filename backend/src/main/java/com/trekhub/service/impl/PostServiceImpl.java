package com.trekhub.service.impl;

import com.trekhub.dto.request.CreatePostRequest;
import com.trekhub.dto.response.AuthorSummaryResponse;
import com.trekhub.dto.response.PostResponse;
import com.trekhub.dto.response.TrailSummaryResponse;
import com.trekhub.entity.Post;
import com.trekhub.entity.Trail;
import com.trekhub.entity.User;
import com.trekhub.enums.SportCategory;
import com.trekhub.repository.PostRepository;
import com.trekhub.repository.TrailRepository;
import com.trekhub.repository.UserRepository;
import com.trekhub.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final TrailRepository trailRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, TrailRepository trailRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.trailRepository = trailRepository;
    }

    @Override
    @Transactional
    public PostResponse createPost(CreatePostRequest request) {
        User author = userRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy người dùng với ID: " + request.getAuthorId()));

        Post post = new Post();
        post.setAuthor(author);
        post.setCaption(request.getCaption());
        post.setSportCategory(request.getSportCategory() != null ? request.getSportCategory() : SportCategory.TREKKING);
        post.setMediaUrls(request.getMediaUrls() != null ? request.getMediaUrls() : java.util.Collections.emptyList());
        post.setDistanceKm(request.getDistanceKm());
        post.setElevationGainMeters(request.getElevationGainMeters());
        post.setDurationDays(request.getDurationDays());
        post.setWeatherCondition(request.getWeatherCondition());

        // Kiểm tra gắn thẻ đỉnh núi & Thuật toán xác thực chạm đỉnh (Summit Verification)
        if (request.getTaggedTrailId() != null) {
            Trail trail = trailRepository.findById(request.getTaggedTrailId()).orElse(null);
            if (trail != null) {
                post.setTaggedTrail(trail);

                // Nếu có GPS check-in và tọa độ đỉnh
                if (request.getCheckinLatitude() != null && request.getCheckinLongitude() != null
                        && trail.getLatitude() != null && trail.getLongitude() != null) {
                    double distanceToSummitMeters = calculateHaversineDistance(
                            request.getCheckinLatitude(), request.getCheckinLongitude(),
                            trail.getLatitude(), trail.getLongitude()
                    );

                    // Nếu vị trí check-in cách đỉnh núi <= 250 mét -> Tự động xác thực chạm đỉnh!
                    if (distanceToSummitMeters <= 250.0) {
                        post.setSummitVerified(true);
                        author.setSummitsCount(author.getSummitsCount() + 1);
                        if (request.getElevationGainMeters() != null) {
                            author.setTotalElevationGain(author.getTotalElevationGain() + request.getElevationGainMeters());
                        }
                        if (request.getDistanceKm() != null) {
                            author.setTotalDistanceKm(author.getTotalDistanceKm() + request.getDistanceKm());
                        }
                        userRepository.save(author);
                    }
                }
            }
        }

        Post savedPost = postRepository.save(post);
        return mapToResponse(savedPost);
    }

    @Override
    public Page<PostResponse> getFeedPosts(Pageable pageable) {
        return postRepository.findFeedPosts(pageable).map(this::mapToResponse);
    }

    @Override
    public Page<PostResponse> getPostsByAuthor(UUID authorId, Pageable pageable) {
        return postRepository.findByAuthorId(authorId, pageable).map(this::mapToResponse);
    }

    @Override
    public Page<PostResponse> getPostsByTrail(Long trailId, Pageable pageable) {
        return postRepository.findByTaggedTrailId(trailId, pageable).map(this::mapToResponse);
    }

    @Override
    public PostResponse getPostById(UUID id) {
        Post post = postRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy bài viết kỷ niệm với ID: " + id));
        return mapToResponse(post);
    }

    @Override
    @Transactional
    public void addKudos(UUID postId, UUID userId) {
        Post post = postRepository.findByIdAndDeletedFalse(postId)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy bài viết kỷ niệm"));
        post.setKudosCount(post.getKudosCount() + 1);
        postRepository.save(post);
    }

    /**
     * Thuật toán Haversine tính khoảng cách giữa 2 tọa độ GPS (trả về mét)
     */
    private double calculateHaversineDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371000; // Bán kính Trái Đất (mét)
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

    private PostResponse mapToResponse(Post post) {
        PostResponse res = new PostResponse();
        res.setId(post.getId());
        res.setCaption(post.getCaption());
        res.setSportCategory(post.getSportCategory());
        res.setMediaUrls(post.getMediaUrls());
        res.setDistanceKm(post.getDistanceKm());
        res.setElevationGainMeters(post.getElevationGainMeters());
        res.setDurationDays(post.getDurationDays());
        res.setWeatherCondition(post.getWeatherCondition());
        res.setSummitVerified(post.isSummitVerified());
        res.setKudosCount(post.getKudosCount());
        res.setCommentCount(post.getCommentCount());
        res.setShareCount(post.getShareCount());
        res.setCreatedAt(post.getCreatedAt());

        if (post.getAuthor() != null) {
            User a = post.getAuthor();
            res.setAuthor(new AuthorSummaryResponse(
                    a.getId(), a.getUsername(), a.getFullName(),
                    a.getAvatarUrl(), a.getSummitsCount(), a.getLevel(),
                    a.isLeaveNoTraceAmbassador()
            ));
        }

        if (post.getTaggedTrail() != null) {
            Trail t = post.getTaggedTrail();
            res.setTaggedTrail(new TrailSummaryResponse(
                    t.getId(), t.getName(), t.getSlug(), t.getRegion(),
                    t.getPeakElevation(), t.getElevationGain(), t.getDistanceKm(),
                    t.getDifficultyLevel(), t.getCoverImageUrl()
            ));
        }

        return res;
    }
}
