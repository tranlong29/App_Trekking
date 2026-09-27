package com.trekhub.service;

import com.trekhub.dto.request.CreatePostRequest;
import com.trekhub.dto.response.PostResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PostService {
    PostResponse createPost(CreatePostRequest request);
    Page<PostResponse> getFeedPosts(Pageable pageable);
    Page<PostResponse> getPostsByAuthor(UUID authorId, Pageable pageable);
    Page<PostResponse> getPostsByTrail(Long trailId, Pageable pageable);
    PostResponse getPostById(UUID id);
    void addKudos(UUID postId, UUID userId);
}
