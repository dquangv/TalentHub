package org.example.backend.repository;

import org.example.backend.entity.child.account.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    public PasswordResetToken findByOtpAndEmail(String token, String email);
}
