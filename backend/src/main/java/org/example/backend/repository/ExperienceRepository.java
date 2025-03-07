package org.example.backend.repository;

import org.example.backend.entity.child.account.freelancer.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
