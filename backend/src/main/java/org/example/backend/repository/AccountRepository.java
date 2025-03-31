package org.example.backend.repository;

import org.example.backend.entity.child.account.Account;
import org.example.backend.enums.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> getByEmail(String email);

    boolean existsByEmail(String email);

    Optional<Account> findByEmail(String email);

    @Query("SELECT COUNT(a) FROM Account a WHERE YEAR(a.createdAt) = :year AND MONTH(a.createdAt) = :month AND a.role = :role")
    Long countAccountsByRoleAndMonth(@Param("year") int year, @Param("month") int month, @Param("role") RoleUser role);
}
