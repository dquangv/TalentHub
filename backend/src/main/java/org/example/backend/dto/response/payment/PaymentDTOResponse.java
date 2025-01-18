package org.example.backend.dto.response.payment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class PaymentDTOResponse {
    private Long id;
    private boolean isDefault;
    private BankAccountDTOResponse bankAccount;
    private EWalletAccountDTOResponse eWalletAccount;
}