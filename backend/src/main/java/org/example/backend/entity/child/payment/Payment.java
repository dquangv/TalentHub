package org.example.backend.entity.child.payment;

import com.google.type.DateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;
import org.example.backend.entity.child.account.Account;
import org.example.backend.enums.StatusPayment;

import java.math.BigInteger;

@Table(name = "payment")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends AbstractEntity<Long> {

    @Column(name = "balance")
    private BigInteger balance;

    @Column(name = "activity")
    private StatusPayment activity;

    @Column(name = "update_at")
    private DateTime updateAt;

    @OneToOne
    @JoinColumn(name = "account_id", unique = true)
    private Account account;
}
