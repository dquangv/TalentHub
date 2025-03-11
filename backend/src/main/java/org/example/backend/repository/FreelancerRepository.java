package org.example.backend.repository;

import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

public interface FreelancerRepository extends JpaRepository<Freelancer,Long> {
    public Optional<Freelancer> findByUserId(Long userId);

    @Transactional
    @Modifying
    @Query("UPDATE Freelancer f " +
            "SET f.hourlyRate = :hourlyRate " +
            "WHERE f.id = :freelancerId")
    Freelancer updateHourlyRate(@Param("freelancerId") Long freelancerId, @Param("hourlyRate") BigDecimal hourlyRate);
}
