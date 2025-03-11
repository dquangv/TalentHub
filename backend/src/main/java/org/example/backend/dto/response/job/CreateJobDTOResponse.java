package org.example.backend.dto.response.job;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.backend.enums.StatusJob;
import org.example.backend.enums.TypePayment;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class CreateJobDTOResponse {
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
