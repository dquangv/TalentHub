package org.example.backend.repository;

import org.example.backend.entity.child.account.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    public Optional<Client> findByUserId(Long userId);
}
