package org.example.backend.repository;

import org.example.backend.entity.child.account.freelancer.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVRepsitory extends JpaRepository<Project, Long> {
}
