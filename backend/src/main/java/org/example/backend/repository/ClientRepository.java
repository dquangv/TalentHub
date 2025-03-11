package org.example.backend.repository;

import org.example.backend.entity.child.account.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    public Optional<Client> findByUserId(Long userId);
}
