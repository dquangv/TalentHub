package org.example.backend.dto.response.account.admin;

import lombok.Data;

@Data
public class VoucherPackageDTOResponse {
    private Long id;
    private String name;
    private Double price;
    private Long duration;
    private boolean status;
    private String createdAt;
    private String updatedAt;
    private Long accountId;
}