package org.example.backend.entity.child.payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;
import org.example.backend.entity.child.account.Account;
import org.example.backend.enums.ActivityType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "payment")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends AbstractEntity<Long> {

    @Column(name = "balance")
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "activity")
    private ActivityType activity;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;


    @Column(name = "updated_at", insertable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

//    @Column(name = "is_default")
//    private boolean isDefault;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "bank_account_id") // Khóa ngoại trỏ đến BankAccount
//    private BankAccount bankAccount;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "e_wallet_account_id") // Khóa ngoại trỏ đến EWalletAccount
//    private EWalletAccount eWalletAccount;

    @OneToOne
    @JoinColumn(name = "account_id", unique = true)
    private Account account;
}
