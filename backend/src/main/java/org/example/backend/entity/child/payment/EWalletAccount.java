package org.example.backend.entity.child.payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;

@Table(name = "e_wallet_account")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EWalletAccount extends AbstractEntity<Long> {

    @Column(name = "e_wallet_name")
    private String eWalletName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "eWalletAccount")
    private Payment payment;
}
