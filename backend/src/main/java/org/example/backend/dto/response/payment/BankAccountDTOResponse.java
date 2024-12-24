package org.example.backend.dto.response.payment;

import com.google.type.DateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDTOResponse {
    private Long id;
    private String bankName;
    private int bankAccountNumber;
    private String branch;
    private DateTime startDate;
    private Boolean status;
    private PaymentDTOResponse payment;
}
