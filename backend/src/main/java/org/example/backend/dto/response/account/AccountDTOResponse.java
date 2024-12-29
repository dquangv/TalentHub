package org.example.backend.dto.response.account;

import com.google.type.DateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.backend.dto.UserDTO;
import org.example.backend.dto.response.payment.PaymentDTOResponse;
import org.example.backend.entity.child.account.User;
import org.example.backend.entity.child.payment.Payment;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class AccountDTOResponse {
    private Long id;
    private String email;
    private String role;
    private Boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserDTO user;
    private List<PaymentDTOResponse> payments;
}
