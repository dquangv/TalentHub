package org.example.backend.dto.request.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.entity.child.job.JobSkill;
import org.example.backend.enums.StatusJob;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobAdminDTOResponse {
    private String title;
    private String scope;
    private BigDecimal hourWork;
    private Long duration;
    private Boolean jobOpportunity;
    private BigDecimal fromPrice;
    private BigDecimal toPrice;
    private String typePrice;
    private StatusJob status;
    private String clientEmail;
    private String categoryName;
    private Long quantity;
    private Long appliedQuantity;
    private Long cancelledQuantity;
    private Long inProgressQuantity;
    private Long viewedQuantity;
}
