package org.example.backend.repository;

import org.example.backend.dto.response.payment.PaymentSummaryDTO;
import org.example.backend.entity.child.account.Account;
import org.example.backend.entity.child.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
//    @Query("SELECT COALESCE(SUM(p.balance), 0) " +
//            "FROM Payment p " +
//            "WHERE p.account.id = :accountId")
//    BigDecimal getTotalAmountByAccountId(@Param("accountId") Long accountId);


//    @Query("SELECT new org.example.backend.dto.response.payment.PaymentSummaryDTO(" +
//            "t.activity, CAST(COALESCE(SUM(t.money), 0) AS BigDecimal), MAX(t.createdAt), MIN(t.createdAt)) " +
//            "FROM  Transactions t " +
//            "WHERE t.payment.account.id = :accountId " +
//            "AND (t.activity = 'DEPOSIT' OR t.activity = 'WITHDRAW')  " +
//            "AND FUNCTION('DATE', t.createdAt) = (" +
//            "    SELECT FUNCTION('DATE', MAX(t2.createdAt)) FROM Transactions t2 WHERE t2.payment.account.id = :accountId" +
//            ") " +
//            "GROUP BY t.activity")
//    List<PaymentSummaryDTO> getLatestPaymentInfo(@Param("accountId") Long accountId);


    @Query("""
    SELECT new org.example.backend.dto.response.payment.PaymentSummaryDTO(
        t.activity,
        t.money,
        t.createdAt
    )
    FROM Transactions t
    WHERE t.payment.account.id = :accountId
      AND t.activity = 'DEPOSIT'
    ORDER BY t.createdAt DESC
""")
    List<PaymentSummaryDTO> findLatestDeposit(@Param("accountId") Long accountId, Pageable pageable);

    @Query("""
    SELECT new org.example.backend.dto.response.payment.PaymentSummaryDTO(
        t.activity,
        t.money,
        t.createdAt
    )
    FROM Transactions t
    WHERE t.payment.account.id = :accountId
      AND t.activity = 'WITHDRAW'
    ORDER BY t.createdAt DESC
""")
    List<PaymentSummaryDTO> findLatestWithdraw(@Param("accountId") Long accountId, Pageable pageable);

    @Query("""
    SELECT MIN(t.createdAt)
    FROM Transactions t
    WHERE t.payment.account.id = :accountId
""")
    LocalDateTime getCreatedAtById(@Param("accountId") Long accountId);

    Optional<Payment> findByAccountId(Long accountId);

}
