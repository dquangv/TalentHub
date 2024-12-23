package org.example.backend.repository;

import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerRepository extends JpaRepository<Freelancer,Long> {
}
