package org.example.backend.repository;

import org.example.backend.entity.child.job.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
