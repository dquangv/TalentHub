package org.example.backend.repository;

import org.example.backend.dto.response.account.freelancer.ApplicantResponseDTO;
import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.enums.StatusFreelancerJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface FreelancerJobRepository extends JpaRepository<FreelancerJob, Long> {
    Optional<FreelancerJob> findByFreelancer_IdAndJob_Id(Long freelancerId, Long jobId);

    Long countByFreelancerIdAndStatus(Long freelancerId, StatusFreelancerJob status);
    @Query("SELECT fj.id, " +
            "u.firstName, " +
            "u.lastName, " +
            "a.email, " +
            "u.image, " +
            "e.position, " +
            "fj.appliedDate, " +
            "fj.status, " +
            "COALESCE(fr.rating, 0) " +
            "FROM Account a " +
            " right JOIN User u ON u.account.id = a.id " +
            "right JOIN Freelancer f ON f.user.id = u.id " +
            "JOIN FreelancerJob fj ON fj.freelancer.id = f.id " +
            "JOIN Experience e ON e.freelancer.id = f.id " +
            "JOIN Job j ON fj.job.id = j.id " +
            "LEFT JOIN FreelancerReview fr ON fr.id = fj.freelancerReview.id " +
            "WHERE j.id = :jobId")
    List<FreelancerJob> getApplicantByJobId(@Param("jobId") Long jobId);

}
