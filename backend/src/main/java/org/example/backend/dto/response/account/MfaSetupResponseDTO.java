package org.example.backend.dto.response.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MfaSetupResponseDTO {
    private String secretKey;
    private String qrCodeImage;
}