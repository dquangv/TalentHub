package org.example.backend.repository;

import org.example.backend.entity.child.ReportedJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportedJobRepository extends JpaRepository<ReportedJob, Long> {
}
