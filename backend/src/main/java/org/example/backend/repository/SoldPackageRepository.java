package org.example.backend.repository;

import org.example.backend.entity.child.account.client.SoldPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public interface SoldPackageRepository extends JpaRepository<SoldPackage, Long> {
    List<SoldPackage> findByEndDateBeforeAndStatus(LocalDateTime endDate, boolean status);

    SoldPackage findTopByClientIdAndStatusOrderByStartDateDesc(Long clientId, boolean status);

}
