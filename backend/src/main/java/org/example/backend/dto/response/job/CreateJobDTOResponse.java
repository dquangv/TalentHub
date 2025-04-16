package org.example.backend.dto.response.job;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.backend.enums.StatusJob;
import org.example.backend.enums.TypePayment;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class CreateJobDTOResponse {
    private Long jobId;
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
    private List<Long> skillId;
    private Date createdAt;
    private String createdTimeFormatted;
}
