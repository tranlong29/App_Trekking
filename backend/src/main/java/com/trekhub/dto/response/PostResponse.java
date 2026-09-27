package com.trekhub.dto.response;

import com.trekhub.enums.SportCategory;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class PostResponse {
    private UUID id;
    private AuthorSummaryResponse author;
    private String caption;
    private SportCategory sportCategory;
    private List<String> mediaUrls;
    private TrailSummaryResponse taggedTrail;
    private Double distanceKm;
    private Double elevationGainMeters;
    private Integer durationDays;
    private String weatherCondition;
    private boolean isSummitVerified;
    private int kudosCount;
    private int commentCount;
    private int shareCount;
    private Instant createdAt;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AuthorSummaryResponse getAuthor() {
        return author;
    }

    public void setAuthor(AuthorSummaryResponse author) {
        this.author = author;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public SportCategory getSportCategory() {
        return sportCategory;
    }

    public void setSportCategory(SportCategory sportCategory) {
        this.sportCategory = sportCategory;
    }

    public List<String> getMediaUrls() {
        return mediaUrls;
    }

    public void setMediaUrls(List<String> mediaUrls) {
        this.mediaUrls = mediaUrls;
    }

    public TrailSummaryResponse getTaggedTrail() {
        return taggedTrail;
    }

    public void setTaggedTrail(TrailSummaryResponse taggedTrail) {
        this.taggedTrail = taggedTrail;
    }

    public Double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(Double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public Double getElevationGainMeters() {
        return elevationGainMeters;
    }

    public void setElevationGainMeters(Double elevationGainMeters) {
        this.elevationGainMeters = elevationGainMeters;
    }

    public Integer getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public boolean isSummitVerified() {
        return isSummitVerified;
    }

    public void setSummitVerified(boolean summitVerified) {
        isSummitVerified = summitVerified;
    }

    public int getKudosCount() {
        return kudosCount;
    }

    public void setKudosCount(int kudosCount) {
        this.kudosCount = kudosCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
