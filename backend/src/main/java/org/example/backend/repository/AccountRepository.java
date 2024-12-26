package org.example.backend.repository;

import org.example.backend.entity.child.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> getByEmail(String email);
    Boolean existsByEmail(String email);
}
