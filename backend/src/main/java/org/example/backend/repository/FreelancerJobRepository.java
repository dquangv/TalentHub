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
    // tim freelancer job theo freelancer va job
    Optional<FreelancerJob> findByFreelancer_IdAndJob_Id(Long freelancerId, Long jobId);

    // dem so luong freelancer job theo freelancer va status
    Long countByFreelancerIdAndStatus(Long freelancerId, StatusFreelancerJob status);

    List<FreelancerJob> getApplicantByJobId(Long jobId);

    @Query("select fj " +
            "from FreelancerJob fj " +
            "left join fetch fj.job j " +
            "left join fetch j.category cg " +
            "left join fetch j.jobSkills js " +
            "left join fetch j.client c " +
            "where fj.isSaved = true and fj.job.id = :jobID")
    List<FreelancerJob> getSavedJobs(Long jobID);

    @Query("select fj " +
            "from FreelancerJob fj " +
            "left join fetch fj.job j " +
            "left join fetch j.category cg " +
            "left join fetch j.jobSkills js " +
            "left join fetch j.client c " +
            "where fj.job.id = :jobID")
    List<FreelancerJob> getApplyJobs(Long jobID);


//  @Query("select fj.id," +
//            "u.firstName," +
//            "u.lastName," +
//            "u.image," +
//            "e.position," +
//            "fj.appliedDate," +
//            "fj.status," +
//            "fr.rating " +
//            "from FreelancerJob fj " +
//            "left join fj.freelancerReview fr " +
//            "left join fj.freelancer f " +
//            "left join f.experiences e " +
//            "left join f.user u " +
//            "left join u.account a " +
//            "where fj.job.id = :jobId ")
//    List<Object[]> getApplicantByJobId(@Param("jobId") Long jobId);



}
