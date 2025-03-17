package org.example.backend.entity.child.account.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.AbstractEntity;
import org.example.backend.entity.child.admin.VoucherPackage;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "sold_packages")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SoldPackage extends AbstractEntity<Long> {
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price")
    private Double price;

    @Column(name = "status")
    // true = valid; false = expired
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "voucher_packages")
    private VoucherPackage voucherPackage;

    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;
}
