package org.example.backend.repository;

import org.example.backend.entity.child.payment.EWalletAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EWalletAccountRepository extends JpaRepository<EWalletAccount, Long> {
}
