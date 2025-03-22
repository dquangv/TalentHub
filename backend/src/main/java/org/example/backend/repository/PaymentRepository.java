package org.example.backend.repository;

import org.example.backend.dto.response.payment.PaymentSummaryDTO;
import org.example.backend.entity.child.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("SELECT COALESCE(SUM(p.balance), 0) " +
            "FROM Payment p " +
            "WHERE p.account.id = :accountId")
    BigDecimal getTotalAmountByAccountId(@Param("accountId") Long accountId);


    @Query("SELECT new org.example.backend.dto.response.payment.PaymentSummaryDTO(" +
            "p.activity, CAST(COALESCE(SUM(p.balance), 0) AS BigDecimal), MAX(p.createdAt)) " +
            "FROM Payment p " +
            "WHERE p.account.id = :accountId " +
            "AND (p.activity = 'DEPOSIT' OR p.activity = 'WITHDRAW') " +
            "GROUP BY p.activity")
    List<PaymentSummaryDTO> getLatestPaymentInfo(@Param("accountId") Long accountId);

}
