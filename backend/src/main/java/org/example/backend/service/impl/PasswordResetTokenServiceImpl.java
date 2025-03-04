package org.example.backend.service.impl;

import org.example.backend.dto.request.account.PasswordResetTokenDTORequest;
import org.example.backend.dto.request.account.VerifyCodeDTORequest;
import org.example.backend.dto.response.account.PasswordResetTokenDTOResponse;
import org.example.backend.entity.child.account.Account;
import org.example.backend.entity.child.account.PasswordResetToken;
import org.example.backend.repository.AccountRepository;
import org.example.backend.repository.PasswordResetTokenRepository;
import org.example.backend.service.intf.account.PasswordResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public PasswordResetTokenDTOResponse resetPassword(PasswordResetTokenDTORequest passwordResetTokenDTORequest) {
        PasswordResetToken passwordResetToken = tokenRepository.findByOtpAndEmail(passwordResetTokenDTORequest.getCode(), passwordResetTokenDTORequest.getEmail());

        if (passwordResetToken == null || passwordResetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            return new PasswordResetTokenDTOResponse("Token is expired", false);
        }

        Optional<Account> account = accountRepository.findByEmail(passwordResetToken.getEmail());
        if (account.isEmpty()) {
            return new PasswordResetTokenDTOResponse("Account with this email is not found", false);
        }

        Account foundAccount = account.get();
        foundAccount.setPassword(passwordEncoder.encode(passwordResetTokenDTORequest.getNewPassword()));
        accountRepository.save(foundAccount);

        tokenRepository.delete(passwordResetToken);

        return new PasswordResetTokenDTOResponse("The password is reset", true);
    }

    public PasswordResetTokenDTOResponse checkOtp(VerifyCodeDTORequest verifyCodeDTORequest) {
        PasswordResetToken passwordResetToken = tokenRepository.findByOtpAndEmail(verifyCodeDTORequest.getCode(), verifyCodeDTORequest.getEmail());
        if (passwordResetToken == null) {
            return new PasswordResetTokenDTOResponse("Invalid OTP", false);
        }

        if (passwordResetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            return new PasswordResetTokenDTOResponse("OTP has expired", false);
        }

        return new PasswordResetTokenDTOResponse("OTP is valid", true);
    }
}
