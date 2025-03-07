package org.example.backend.dto.request.account.admin;

import lombok.Data;

@Data
public class VoucherPackageDTORequest {
    private String name;
    private Double price;
    private Long duration;
    private boolean status;
    private Long accountId;
}