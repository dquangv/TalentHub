package org.example.backend.repository;

import org.example.backend.entity.child.job.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
