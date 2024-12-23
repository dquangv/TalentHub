package org.example.backend.repository;

import org.example.backend.entity.child.job.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
