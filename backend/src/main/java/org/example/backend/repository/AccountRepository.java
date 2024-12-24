package org.example.backend.repository;

import org.example.backend.entity.child.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account getByEmail(String email);
}
