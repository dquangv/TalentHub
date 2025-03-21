package org.example.backend.enums;

public enum TypePackage {
    NORMAL("Gói thường"),
    SILVER("Gói bạc"),
    GOLD("Gói vàng"),
    DIAMOND("Gói kim cương");

    private final String displayName;

    // Constructor với displayName
    TypePackage(String displayName) {
        this.displayName = displayName;
    }

    // Getter cho displayName
    public String getDisplayName() {
        return displayName;
    }

    public static TypePayment fromString(String paymentType) {
        for (TypePayment type : TypePayment.values()) {
            if (type.getDisplayName().equalsIgnoreCase(paymentType)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown payment type: " + paymentType);
    }
}
