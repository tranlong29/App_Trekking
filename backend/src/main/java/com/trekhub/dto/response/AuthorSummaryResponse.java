package com.trekhub.dto.response;

import java.util.UUID;

public class AuthorSummaryResponse {
    private UUID id;
    private String username;
    private String fullName;
    private String avatarUrl;
    private int summitsCount;
    private int level;
    private boolean isLeaveNoTraceAmbassador;

    public AuthorSummaryResponse() {}

    public AuthorSummaryResponse(UUID id, String username, String fullName, String avatarUrl, int summitsCount, int level, boolean isLeaveNoTraceAmbassador) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.avatarUrl = avatarUrl;
        this.summitsCount = summitsCount;
        this.level = level;
        this.isLeaveNoTraceAmbassador = isLeaveNoTraceAmbassador;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getSummitsCount() {
        return summitsCount;
    }

    public void setSummitsCount(int summitsCount) {
        this.summitsCount = summitsCount;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isLeaveNoTraceAmbassador() {
        return isLeaveNoTraceAmbassador;
    }

    public void setLeaveNoTraceAmbassador(boolean leaveNoTraceAmbassador) {
        isLeaveNoTraceAmbassador = leaveNoTraceAmbassador;
    }
}
