package org.example.backend.repository;

import org.example.backend.entity.child.account.client.ClientReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientReviewRepository extends JpaRepository<ClientReview, Long> {
    @Query("SELECT AVG(c.rating) FROM FreelancerJob fj " +
            "JOIN fj.clientReview c " +
            "WHERE fj.freelancer.id = :freelancerId")
    Float findAverageRating(@Param("freelancerId") Long freelancerId);
}
