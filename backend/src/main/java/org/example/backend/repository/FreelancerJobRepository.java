package org.example.backend.repository;

import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.enums.StatusFreelancerJob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Optional;

public interface FreelancerJobRepository extends JpaRepository<FreelancerJob, Long> {
    Optional<FreelancerJob> findByFreelancer_IdAndJob_Id(Long freelancerId, Long jobId);
    Long countByFreelancerIdAndStatus(Long freelancerId, StatusFreelancerJob status);
}
