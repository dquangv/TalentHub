package org.example.backend.repository;

import org.example.backend.entity.child.job.JobSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSkillRepository extends JpaRepository<JobSkill, Long> {
    Long countBySkillId(Long skillId);
}
