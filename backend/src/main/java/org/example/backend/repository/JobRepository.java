    package org.example.backend.repository;

    import org.example.backend.dto.response.job.JobDTOResponse;
    import org.example.backend.entity.child.job.Category;
    import org.example.backend.entity.child.job.Job;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import org.example.backend.enums.StatusJob;

    import java.util.Date;
    import java.util.List;
    import java.util.Optional;

    public interface JobRepository extends JpaRepository<Job, Long> {
        List<Job> findByCategory(Category category);
        public Long countByCategoryId(Long categoryId);
        @Query("SELECT j FROM Job j " +
                "LEFT JOIN FETCH j.client c " +
                "LEFT JOIN FETCH c.user " +
                "LEFT JOIN FETCH j.category " +
                "LEFT JOIN FETCH j.jobSkills js " +
                "LEFT JOIN FETCH js.skill " +
                "WHERE j.id = :id")
        Optional<Job> getDetailJobById(@Param("id") Long id);


        @Query("SELECT j FROM Job j " +
                "LEFT JOIN FETCH j.client c " +
                "WHERE c.id = :clientId")
        List<Job> getPostedJobs(@Param("clientId") Long clientId);
        long countByStatus(StatusJob status);

        List<Job> findByStatus(StatusJob status);

        List<Job> findByEndDateLessThanEqualAndStatusNot(Date endDate, StatusJob status);

    }
