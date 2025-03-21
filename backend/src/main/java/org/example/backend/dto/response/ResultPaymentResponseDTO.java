package org.example.backend.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.backend.enums.ActivityType;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ResultPaymentResponseDTO {
    private String codeVnp;
    private String fristName;
    private String lastName;
    private BigDecimal amount;
    private ActivityType activity;
}
