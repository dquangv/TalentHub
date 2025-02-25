package org.example.backend.enums;

public enum StatusPayment {
    WITHDRAW("Rút tiền"),
    DEPOSIT("Nạp tiền");

    private final String displayName;

    // Constructor với displayName
    StatusPayment(String displayName) {
        this.displayName = displayName;
    }

    // Getter cho displayName
    public String getDisplayName() {
        return displayName;
    }

    public static StatusPayment fromString(String paymentType) {
        for (StatusPayment type : StatusPayment.values()) {
            if (type.getDisplayName().equalsIgnoreCase(paymentType)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown payment type: " + paymentType);
    }
}
