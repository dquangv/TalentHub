package org.example.backend.entity.child.payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;
import org.example.backend.entity.child.account.Account;
import org.example.backend.enums.ActivityType;
import org.example.backend.enums.TransactionStatus;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "transactions")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transactions extends AbstractEntity<Long> {

    @Column(name = "money")
    private BigDecimal money;

    @Enumerated(EnumType.STRING)
    @Column(name = "activity")
    private ActivityType activity;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TransactionStatus status;

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

}
