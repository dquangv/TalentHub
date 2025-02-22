package org.example.backend.enums;

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
