package org.example.backend.dto.request.payment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.type.DateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountDTORequest {
    @NotBlank(message = "Bank name cannot be blank")
    @Size(max = 100, message = "Bank name cannot exceed 100 characters")
    private String bankName;

    @NotNull(message = "Bank account number cannot be null")
    private Integer bankAccountNumber;

    @NotBlank(message = "Branch cannot be blank")
    @Size(max = 50, message = "Branch cannot exceed 50 characters")
    private String branch;

    @NotNull(message = "Start date cannot be null")
    @PastOrPresent(message = "Start date cannot be in the future")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private DateTime startDate;

    @NotNull(message = "Status cannot be null")
    private Boolean status;

    @NotNull(message = "Payment id cannot be null")
    private Long paymentId;
}
