package org.example.backend.enums;

import com.fasterxml.jackson.annotation.JsonValue;
public enum RoleUser {
    FREELANCER("Freelancer"),
    CLIENT("Client"),
    ADMIN("Admin");

    private final String value;

    RoleUser(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
