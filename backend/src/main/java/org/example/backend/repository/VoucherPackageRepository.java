package org.example.backend.repository;

import org.example.backend.entity.child.admin.VoucherPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherPackageRepository extends JpaRepository<VoucherPackage, Long> {
}
