package org.example.backend.repository;

import org.example.backend.entity.child.account.client.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> getCompanyByClientId(Long aLong);
}
