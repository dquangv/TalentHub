package org.example.backend.repository;

import org.example.backend.entity.child.account.freelancer.FreelancerSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerSkillRepository extends JpaRepository<FreelancerSkill, Long> {
}
