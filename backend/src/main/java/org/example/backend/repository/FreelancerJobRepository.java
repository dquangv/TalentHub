package org.example.backend.repository;

import org.example.backend.entity.child.job.FreelancerJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerJobRepository extends JpaRepository<FreelancerJob, Long> {
}
