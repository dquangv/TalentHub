package org.example.backend.service.intf.account;

import org.example.backend.dto.request.account.PasswordResetTokenDTORequest;
import org.example.backend.dto.request.account.VerifyCodeDTORequest;
import org.example.backend.dto.response.account.PasswordResetTokenDTOResponse;

public interface PasswordResetTokenService {
    PasswordResetTokenDTOResponse checkOtp(VerifyCodeDTORequest request);

    PasswordResetTokenDTOResponse resetPassword(PasswordResetTokenDTORequest passwordResetTokenDTORequest);
}
