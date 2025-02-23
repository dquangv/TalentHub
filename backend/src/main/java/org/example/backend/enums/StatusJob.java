package org.example.backend.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusJob {
    OPEN("Mở"),
    CLOSE("Đóng"),
    Pending("Chờ xử lý"),
    BAN("Bị cấm");

    private final String displayName;

    // Constructor với displayName
    StatusJob(String displayName) {
        this.displayName = displayName;
    }

    // Getter cho displayName
    @JsonValue
    public String getDisplayName() {
        return displayName;
    }


    public static ProgressJob fromString(String status) {
        for (ProgressJob jobStatus : ProgressJob.values()) {
            if (jobStatus.getDisplayName().equalsIgnoreCase(status)) {
                return jobStatus;
            }
        }
        throw new IllegalArgumentException("Unknown status: " + status);
    }
}
