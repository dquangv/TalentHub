package org.example.backend.entity.child.payment;

import com.google.type.DateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;

import java.time.LocalDateTime;

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
    private Long bankAccountNumber;

    @Column(name = "branch")
    private String branch;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "status")
    private Boolean status;

    @OneToOne(mappedBy = "bankAccount",  cascade = CascadeType.ALL)
    private Payment payment;
}
