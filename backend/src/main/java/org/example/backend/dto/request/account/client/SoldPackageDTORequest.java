package org.example.backend.dto.request.account.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.enums.TypePackage;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SoldPackageDTORequest {
    private Double price;
    private boolean status;
    private TypePackage typePackage;
    private Long clientId;
}
