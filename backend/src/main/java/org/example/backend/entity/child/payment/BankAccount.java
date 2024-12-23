package org.example.backend.entity.child.payment;

import com.google.type.DateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;

import java.util.Date;

@Table(name = "bank_account")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount extends AbstractEntity<Long> {

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_account_number")
    private int bankAccountNumber;

    @Column(name = "branch")
    private String branch;

    @Column(name = "start_date")
    private DateTime startDate;

    @Column(name = "status")
    private Boolean status;

    @OneToOne(mappedBy = "bankAccount")
    private Payment payment;
}
