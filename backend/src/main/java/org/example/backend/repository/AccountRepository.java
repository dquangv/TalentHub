package org.example.backend.repository;

import org.example.backend.entity.child.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
