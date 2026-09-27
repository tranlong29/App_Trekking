package com.trekhub.controller;

import com.trekhub.common.ApiResponse;
import com.trekhub.dto.response.TrailSummaryResponse;
import com.trekhub.entity.Trail;
import com.trekhub.enums.Region;
import com.trekhub.repository.TrailRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trails")
@Tag(name = "Trails & Peaks", description = "APIs khám phá cung đường leo núi, độ cao, cự ly và tình trạng đường mòn")
public class TrailController {

    private final TrailRepository trailRepository;

    public TrailController(TrailRepository trailRepository) {
        this.trailRepository = trailRepository;
    }

    @GetMapping
    @Operation(summary = "Lấy danh sách các cung đường leo núi (Hỗ trợ lọc theo vùng miền)")
    public ResponseEntity<ApiResponse<Page<TrailSummaryResponse>>> getTrails(
            @RequestParam(required = false) Region region,
            @PageableDefault(size = 12) Pageable pageable) {

        Page<Trail> page = (region != null)
                ? trailRepository.findByRegion(region, pageable)
                : trailRepository.findAll(pageable);

        Page<TrailSummaryResponse> responses = page.map(t -> new TrailSummaryResponse(
                t.getId(), t.getName(), t.getSlug(), t.getRegion(),
                t.getPeakElevation(), t.getElevationGain(), t.getDistanceKm(),
                t.getDifficultyLevel(), t.getCoverImageUrl()
        ));

        return ResponseEntity.ok(ApiResponse.success(responses));
    }

    @GetMapping("/{slug}")
    @Operation(summary = "Xem thông tin chi tiết đầy đủ của một cung đường leo núi qua slug")
    public ResponseEntity<ApiResponse<Trail>> getTrailBySlug(@PathVariable String slug) {
        Trail trail = trailRepository.findBySlug(slug)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy cung đường với slug: " + slug));
        return ResponseEntity.ok(ApiResponse.success(trail));
    }
}
