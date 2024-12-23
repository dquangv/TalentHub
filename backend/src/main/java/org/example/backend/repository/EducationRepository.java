package org.example.backend.repository;

import org.example.backend.entity.child.account.freelancer.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
