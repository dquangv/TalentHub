package org.example.backend.repository;

import org.example.backend.entity.child.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("SELECT COALESCE(SUM(p.balance), 0) " +
            "FROM Payment p " +
            "WHERE p.account.id = :accountId")
    BigDecimal getTotalAmountByAccountId(@Param("accountId") Long accountId);

}
