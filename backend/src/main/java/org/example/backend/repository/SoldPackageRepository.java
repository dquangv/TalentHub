package org.example.backend.repository;

import org.example.backend.entity.child.account.client.SoldPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SoldPackageRepository extends JpaRepository<SoldPackage, Long> {
    List<SoldPackage> findByEndDateBeforeAndStatus(LocalDateTime endDate, boolean status);
}
