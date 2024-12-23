package org.example.backend.repository;

import org.example.backend.entity.child.account.freelancer.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degree, Long> {
}
