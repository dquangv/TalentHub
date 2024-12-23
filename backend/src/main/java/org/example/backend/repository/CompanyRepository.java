package org.example.backend.repository;

import org.example.backend.entity.child.account.client.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
