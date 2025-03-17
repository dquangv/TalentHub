package org.example.backend.repository;

import org.example.backend.entity.child.account.client.SoldPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RevenueRepository extends JpaRepository<SoldPackage, Long> {
    @Query(value = "SELECT MONTH(s.start_date) AS month, SUM(s.price) " +
            "FROM sold_packages s " +
            "WHERE YEAR(s.start_date) = :year " +
            "GROUP BY MONTH(s.start_date) " +
            "ORDER BY month ASC",
            nativeQuery = true)
    List<Object[]> getRevenueByMonth(@Param("year") int year);

    @Query(value = "SELECT CEIL(MONTH(s.start_date) / 3.0) AS quarter, SUM(s.price) " +
            "FROM sold_packages s " +
            "WHERE YEAR(s.start_date) = :year " +
            "GROUP BY CEIL(MONTH(s.start_date) / 3.0) " +
            "ORDER BY quarter ASC",
            nativeQuery = true)
    List<Object[]> getRevenueByQuarter(@Param("year") int year);

    @Query(value = "SELECT YEAR(s.start_date) AS year, SUM(s.price) " +
            "FROM sold_packages s " +
            "GROUP BY YEAR(s.start_date) " +
            "ORDER BY year ASC",
            nativeQuery = true)
    List<Object[]> getRevenueByYear();
}
