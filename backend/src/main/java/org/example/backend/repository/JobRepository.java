    package org.example.backend.repository;

    import org.example.backend.dto.response.job.JobDTOResponse;
    import org.example.backend.entity.child.job.Job;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;

    import java.util.List;

    public interface JobRepository extends JpaRepository<Job, Long> {
        @Query(value = "SELECT \n" +
                "    j.id, \n" +
                "    j.title, \n" +
                "    comp.company_name AS companyName, \n" +
                "    j.hour_work, \n" +
                "    j.from_price, \n" +
                "    j.to_price, \n" +
                "    j.description, \n" +
                "    GROUP_CONCAT(s.skill_name) AS skillNames\n" +
                "FROM \n" +
                "    company comp\n" +
                "JOIN \n" +
                "    client c ON comp.client_id = c.id\n" +
                "JOIN \n" +
                "    job j ON j.client_id = c.id\n" +
                "JOIN \n" +
                "    job_skill js ON j.id = js.job_id\n" +
                "JOIN \n" +
                "    skill s ON js.skill_id = s.id\n" +
                "GROUP BY \n" +
                "    j.id, \n" +
                "    j.title, \n" +
                "    comp.company_name, \n" +
                "    j.hour_work, \n" +
                "    j.from_price, \n" +
                "    j.to_price, \n" +
                "    j.description;\n",
                nativeQuery = true)
        List<Object[]> findAllJobsNative();



    }
