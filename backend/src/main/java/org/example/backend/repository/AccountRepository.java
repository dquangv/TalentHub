package org.example.backend.repository;

import org.example.backend.entity.child.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a, COALESCE(c.id, f.id) AS userId " +
            "FROM Account a " +
            "JOIN a.user u " +
            "LEFT JOIN u.client c " +
            "LEFT JOIN u.freelancer f " +
            "WHERE a.email = :email")
    Optional<Object[]> getByEmail(@Param("email") String email);

    boolean existsByEmail(String email);

}
