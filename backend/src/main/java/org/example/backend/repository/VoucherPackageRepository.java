package org.example.backend.repository;

import org.example.backend.entity.child.account.client.SoldPackage;
import org.example.backend.entity.child.admin.VoucherPackage;
import org.example.backend.enums.TypePackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoucherPackageRepository extends JpaRepository<VoucherPackage, Long> {
    VoucherPackage findTopByTypePackageOrderByIdDesc(TypePackage typePackage);

    /*@Query("SELECT v FROM VoucherPackage v WHERE " +
            "COALESCE(v.updatedAt, v.createdAt) = " +
            "(SELECT MAX(COALESCE(v2.updatedAt, v2.createdAt)) " +
            " FROM VoucherPackage v2 WHERE v2.typePackage = v.typePackage)")
    List<VoucherPackage> findLatestVoucherPackagesByType();*/


    @Query("SELECT v FROM VoucherPackage v WHERE v.createdAt = " +
            "(SELECT MAX(v2.createdAt) FROM VoucherPackage v2 WHERE v2.typePackage = v.typePackage)")
    List<VoucherPackage> findLatestVoucherPackagesByType();

    @Query("SELECT sp FROM SoldPackage sp " +
            "WHERE sp.voucherPackage.typePackage = :type " +
            "AND sp.status = true " +
            "ORDER BY sp.startDate DESC")
    List<SoldPackage> findByVoucherPackageType(TypePackage type);

}
