package org.example.backend.dto.response.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.dto.request.payment.EWalletAccountRequestDTO;
import org.example.backend.dto.response.account.AccountResponseDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponseDTO {
    private Long id;
    private Boolean isDefault;
    private BankAccountResponseDTO bankAccount;
    private EWalletAccountRequestDTO eWalletAccount;
    private AccountResponseDTO account;
}
