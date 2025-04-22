package org.example.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusAccount {
    VERIFIED("Xác thực"),
    UNVERIFIED("Chưa xác thực"),
    BANNED("Khóa");

    private final String displayName;

    StatusAccount(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

    @JsonCreator
    public static StatusJob fromString(String status) {
        for (StatusJob jobStatus : StatusJob.values()) {
            if (jobStatus.getDisplayName().equalsIgnoreCase(status) || jobStatus.name().equalsIgnoreCase(status)) {
                return jobStatus;
            }
        }
        throw new IllegalArgumentException("Unknown status: " + status);
    }
}
