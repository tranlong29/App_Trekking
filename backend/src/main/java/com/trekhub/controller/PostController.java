package com.trekhub.controller;

import com.trekhub.common.ApiResponse;
import com.trekhub.dto.request.CreatePostRequest;
import com.trekhub.dto.response.PostResponse;
import com.trekhub.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
@Tag(name = "Social Feed & Memories", description = "APIs quản lý bài viết kỷ niệm dã ngoại, thông số thể thao và tương tác Kudos")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @Operation(summary = "Đăng kỷ niệm chuyến đi mới (Hỗ trợ album ảnh, GPS check-in và gắn thẻ đỉnh núi)")
    public ResponseEntity<ApiResponse<PostResponse>> createPost(@Valid @RequestBody CreatePostRequest request) {
        PostResponse post = postService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(post, "Đăng kỷ niệm chuyến đi thành công!"));
    }

    @GetMapping("/feed")
    @Operation(summary = "Lấy bảng tin kỷ niệm dã ngoại (Hỗ trợ phân trang vô tận - Infinite scroll)")
    public ResponseEntity<ApiResponse<Page<PostResponse>>> getFeedPosts(
            @PageableDefault(size = 10, sort = "createdAt") Pageable pageable) {
        Page<PostResponse> feed = postService.getFeedPosts(pageable);
        return ResponseEntity.ok(ApiResponse.success(feed, "Lấy danh sách bảng tin thành công"));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Xem chi tiết một bài viết kỷ niệm theo ID")
    public ResponseEntity<ApiResponse<PostResponse>> getPostById(@PathVariable UUID id) {
        PostResponse post = postService.getPostById(id);
        return ResponseEntity.ok(ApiResponse.success(post));
    }

    @GetMapping("/user/{authorId}")
    @Operation(summary = "Lấy danh sách bài viết kỷ niệm của một thành viên")
    public ResponseEntity<ApiResponse<Page<PostResponse>>> getPostsByAuthor(
            @PathVariable UUID authorId,
            @PageableDefault(size = 10) Pageable pageable) {
        Page<PostResponse> posts = postService.getPostsByAuthor(authorId, pageable);
        return ResponseEntity.ok(ApiResponse.success(posts));
    }

    @GetMapping("/trail/{trailId}")
    @Operation(summary = "Lấy danh sách bài viết check-in của một đỉnh núi cụ thể")
    public ResponseEntity<ApiResponse<Page<PostResponse>>> getPostsByTrail(
            @PathVariable Long trailId,
            @PageableDefault(size = 10) Pageable pageable) {
        Page<PostResponse> posts = postService.getPostsByTrail(trailId, pageable);
        return ResponseEntity.ok(ApiResponse.success(posts));
    }

    @PostMapping("/{id}/kudos")
    @Operation(summary = "Thả tim (Tặng Kudos 🥾) cho bài viết kỷ niệm")
    public ResponseEntity<ApiResponse<Void>> addKudos(@PathVariable UUID id, @RequestParam UUID userId) {
        postService.addKudos(id, userId);
        return ResponseEntity.ok(ApiResponse.success(null, "Đã gửi Kudos thành công!"));
    }
}
