package org.example.backend.repository;

import org.example.backend.entity.child.account.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByAccount_Id(Long id);
}
