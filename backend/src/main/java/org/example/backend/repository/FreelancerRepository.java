package org.example.backend.repository;

import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.entity.child.account.freelancer.School;
import org.example.backend.entity.child.job.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface FreelancerRepository extends JpaRepository<Freelancer,Long> {
    public Optional<Freelancer> findByUserId(Long userId);
    public Long countByCategoryId(Long categoryId);
    List<Freelancer> findByCategory(Category category);
}
