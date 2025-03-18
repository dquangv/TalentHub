package org.example.backend.repository;

import org.example.backend.entity.child.account.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    public Optional<Client> findByUserId(Long userId);

    @Transactional
    @Modifying
    @Query("update Client c " +
            "set c.fromPrice = :fromPrice, " +
            "c.toPrice = :toPrice, " +
            "c.typePrice = :typePrice " +
            "where c.id = :clientId")
    void updatePrice(@Param("clientId") Long clientId,
                     @Param("fromPrice")  Double fromPrice,
                     @Param("toPrice")  Double toPrice,
                     @Param("typePrice") String typePrice
                     );
}
