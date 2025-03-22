package org.example.backend.dto.response.payment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.backend.enums.ActivityType;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class WithdrawResponseDTO {
    private BigDecimal amount;
    private ActivityType activityType;
    private String message;
    private String status;
    private BigDecimal remainingBalance;
}
