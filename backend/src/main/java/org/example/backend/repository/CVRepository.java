package org.example.backend.repository;

import org.example.backend.entity.child.account.freelancer.CV;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CVRepository extends JpaRepository<CV, Long> {
    List<CV> findByFreelancer(Freelancer freelancer);
}
