package org.example.backend.dto.response.account;

import org.example.backend.entity.child.account.User;
import org.example.backend.entity.child.payment.Payment;

import java.util.List;

public class AccountDTOResponse {
    private Long id;
    private String email;
    private String role;
    private Boolean status;
    private String createdAt;
    private String updatedAt;
    private User user;
    private List<Payment> payments;
}
