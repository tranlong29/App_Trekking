package com.trekhub.entity;

import com.trekhub.common.BaseAuditEntity;
import com.trekhub.enums.DifficultyLevel;
import com.trekhub.enums.Region;
import jakarta.persistence.*;

@Entity
@Table(name = "trails", indexes = {
    @Index(name = "idx_trails_slug", columnList = "slug", unique = true),
    @Index(name = "idx_trails_region", columnList = "region")
})
public class Trail extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 120)
    private String slug;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Region region;

    @Column(name = "peak_elevation", nullable = false)
    private int peakElevation; // Mét (ví dụ: 2860m)

    @Column(name = "elevation_gain", nullable = false)
    private int elevationGain; // Mét (ví dụ: 1150m)

    @Column(name = "distance_km", nullable = false)
    private double distanceKm; // km (ví dụ: 16.2km)

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty_level", nullable = false, length = 20)
    private DifficultyLevel difficultyLevel;

    @Column(name = "duration_days", nullable = false)
    private int durationDays = 2; // Ví dụ: 2N1Đ

    @Column(name = "best_season", length = 100)
    private String bestSeason; // "Tháng 10 - Tháng 3"

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "gpx_track_url", length = 500)
    private String gpxTrackUrl;

    @Column(name = "cover_image_url", length = 500)
    private String coverImageUrl;

    @Column(name = "estimated_cost")
    private Double estimatedCost; // VNĐ trung bình/người

    @Column(name = "status_bulletin", length = 500)
    private String statusBulletin; // Cập nhật đường mòn gần nhất

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public int getPeakElevation() {
        return peakElevation;
    }

    public void setPeakElevation(int peakElevation) {
        this.peakElevation = peakElevation;
    }

    public int getElevationGain() {
        return elevationGain;
    }

    public void setElevationGain(int elevationGain) {
        this.elevationGain = elevationGain;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }

    public String getBestSeason() {
        return bestSeason;
    }

    public void setBestSeason(String bestSeason) {
        this.bestSeason = bestSeason;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getGpxTrackUrl() {
        return gpxTrackUrl;
    }

    public void setGpxTrackUrl(String gpxTrackUrl) {
        this.gpxTrackUrl = gpxTrackUrl;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public Double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(Double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public String getStatusBulletin() {
        return statusBulletin;
    }

    public void setStatusBulletin(String statusBulletin) {
        this.statusBulletin = statusBulletin;
    }
}
