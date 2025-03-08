package org.example.backend.dto.request.job;

import lombok.*;
import org.example.backend.enums.StatusJob;
import org.example.backend.enums.TypePayment;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class CreateJobDTORequest {
    private String title;
    private String description;
    private String scope;
    private BigDecimal hourWork;
    private Long duration;
    private Boolean jobOpportunity;
    private BigDecimal fromPrice;
    private BigDecimal toPrice;
    private String typePrice;
    private TypePayment typePayment;
    private StatusJob statusJob;
    private Long clientId;
    private Long categoryId;
}
