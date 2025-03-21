package org.example.backend.dto.response.account.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.entity.child.admin.VoucherPackage;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SoldPackageDTOResponse {
    private long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;
    private Long numberPost;
    private Long numberPosted;
    private boolean status;
    private Long voucherPackageId;
    private Long clientId;
}
