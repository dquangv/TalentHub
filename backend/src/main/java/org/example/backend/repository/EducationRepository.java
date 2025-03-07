package org.example.backend.repository;

import org.example.backend.entity.child.account.freelancer.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findByFreelancerId(Long freelancerId);
}
