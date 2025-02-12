package org.example.backend.repository;

import org.example.backend.entity.child.account.freelancer.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
