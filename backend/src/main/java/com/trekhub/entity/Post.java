package com.trekhub.entity;

import com.trekhub.common.BaseAuditEntity;
import com.trekhub.enums.SportCategory;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "posts", indexes = {
    @Index(name = "idx_posts_author_created", columnList = "author_id, created_at DESC"),
    @Index(name = "idx_posts_created_at", columnList = "created_at DESC"),
    @Index(name = "idx_posts_tagged_trail", columnList = "tagged_trail_id")
})
public class Post extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Column(nullable = false, length = 3000)
    private String caption;

    @Enumerated(EnumType.STRING)
    @Column(name = "sport_category", nullable = false, length = 30)
    private SportCategory sportCategory = SportCategory.TREKKING;

    @ElementCollection
    @CollectionTable(name = "post_media_urls", joinColumns = @JoinColumn(name = "post_id"))
    @Column(name = "media_url", length = 500)
    private List<String> mediaUrls = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tagged_trail_id")
    private Trail taggedTrail;

    @Column(name = "distance_km")
    private Double distanceKm; // Ví dụ: 16.2km

    @Column(name = "elevation_gain_meters")
    private Double elevationGainMeters; // Ví dụ: +1150m

    @Column(name = "duration_days")
    private Integer durationDays; // Ví dụ: 2

    @Column(name = "weather_condition", length = 100)
    private String weatherCondition; // Ví dụ: "Biển mây 10/10, Nắng đẹp"

    @Column(name = "is_summit_verified", nullable = false)
    private boolean isSummitVerified = false;

    @Column(name = "kudos_count", nullable = false)
    private int kudosCount = 0;

    @Column(name = "comment_count", nullable = false)
    private int commentCount = 0;

    @Column(name = "share_count", nullable = false)
    private int shareCount = 0;

    @Column(nullable = false)
    private boolean deleted = false;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
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

    public Trail getTaggedTrail() {
        return taggedTrail;
    }

    public void setTaggedTrail(Trail taggedTrail) {
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
