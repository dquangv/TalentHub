package org.example.backend.dto.response.payment;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.backend.entity.child.payment.Payment;
import org.example.backend.enums.ActivityType;
import org.example.backend.enums.TransactionStatus;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TransactionsDTOResponse {
    private Long id;

    private BigDecimal money;

    private ActivityType activity;

    private LocalDateTime createdAt;

    private String description;

    private TransactionStatus status;

}
