package org.example.backend.dto.response.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FreelancerJobDetailDTOResponse {
    private String projectName;
    private String scope;
    private String clientName;
    private Long duration;
    private BigDecimal hourWork;
    private Date startDate;
    private Date endDate;
    private Float rating;
    private String note;
}