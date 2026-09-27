package com.trekhub.dto.response;

import com.trekhub.enums.DifficultyLevel;
import com.trekhub.enums.Region;

public class TrailSummaryResponse {
    private Long id;
    private String name;
    private String slug;
    private Region region;
    private int peakElevation;
    private int elevationGain;
    private double distanceKm;
    private DifficultyLevel difficultyLevel;
    private String coverImageUrl;

    public TrailSummaryResponse() {}

    public TrailSummaryResponse(Long id, String name, String slug, Region region, int peakElevation, int elevationGain, double distanceKm, DifficultyLevel difficultyLevel, String coverImageUrl) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.region = region;
        this.peakElevation = peakElevation;
        this.elevationGain = elevationGain;
        this.distanceKm = distanceKm;
        this.difficultyLevel = difficultyLevel;
        this.coverImageUrl = coverImageUrl;
    }

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

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }
}
