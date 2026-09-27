package com.trekhub.dto.request;

import com.trekhub.enums.SportCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public class CreatePostRequest {

    @NotNull(message = "Tác giả không được để trống")
    private UUID authorId;

    @NotBlank(message = "Nội dung bài viết không được để trống")
    @Size(max = 3000, message = "Nội dung không vượt quá 3000 ký tự")
    private String caption;

    private SportCategory sportCategory = SportCategory.TREKKING;

    private List<String> mediaUrls;

    private Long taggedTrailId;

    private Double distanceKm;

    private Double elevationGainMeters;

    private Integer durationDays;

    private String weatherCondition;

    // Tọa độ người dùng check-in lúc đăng bài (dùng để xác thực chạm đỉnh)
    private Double checkinLatitude;
    private Double checkinLongitude;

    // Getters and Setters
    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
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

    public Long getTaggedTrailId() {
        return taggedTrailId;
    }

    public void setTaggedTrailId(Long taggedTrailId) {
        this.taggedTrailId = taggedTrailId;
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

    public Double getCheckinLatitude() {
        return checkinLatitude;
    }

    public void setCheckinLatitude(Double checkinLatitude) {
        this.checkinLatitude = checkinLatitude;
    }

    public Double getCheckinLongitude() {
        return checkinLongitude;
    }

    public void setCheckinLongitude(Double checkinLongitude) {
        this.checkinLongitude = checkinLongitude;
    }
}
