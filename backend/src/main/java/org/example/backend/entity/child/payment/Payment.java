package org.example.backend.entity.child.payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;
import org.example.backend.entity.child.account.Account;

@Table(name = "payment")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends AbstractEntity<Long> {

    @Column(name = "is_default")
    private boolean isDefault;

    @OneToOne
    @JoinColumn(name = "bank_account_id") // Khóa ngoại trỏ đến BankAccount
    private BankAccount bankAccount;

    @OneToOne
    @JoinColumn(name = "e_wallet_account_id") // Khóa ngoại trỏ đến EWalletAccount
    private EWalletAccount eWalletAccount;

    @ManyToOne
    @JoinColumn(name = "account_id") // Khóa ngoại trỏ đến Account
    private Account account;
}
