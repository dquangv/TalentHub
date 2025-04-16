package org.example.backend.repository;

import org.example.backend.entity.child.account.User;
import org.example.backend.enums.RoleUser;
import org.example.backend.enums.StatusAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByAccount_Id(Long id);
    List<User> findByAccount_RoleAndAccount_Status(RoleUser role, StatusAccount status);
}