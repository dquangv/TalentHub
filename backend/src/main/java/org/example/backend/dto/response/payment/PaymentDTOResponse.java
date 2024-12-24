package org.example.backend.dto.response.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.dto.request.payment.EWalletAccountDTORequest;
import org.example.backend.dto.response.account.AccountDTOResponse;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTOResponse {
    private Long id;
    private Boolean isDefault;
    private BankAccountDTOResponse bankAccount;
    private EWalletAccountDTORequest eWalletAccount;
    private AccountDTOResponse account;
}
