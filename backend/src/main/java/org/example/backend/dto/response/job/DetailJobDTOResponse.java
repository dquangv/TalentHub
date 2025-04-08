package org.example.backend.dto.response.job;

import lombok.Getter;
import lombok.Setter;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.enums.ScopeJob;
import org.example.backend.enums.StatusJob;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class DetailJobDTOResponse {
    private Long id;
    private String title;
    private String companyName;
    private Long clientId;
    private String firstName;
    private String lastName;
    private String type;
    private BigDecimal hourWork;
    private BigDecimal fromPrice;
    private BigDecimal toPrice;
    private String description;
    private List<String> skillNames;
    private StatusJob status;
    private Long totalApplicants;
    private Long duration;
    private ScopeJob scope;
    private boolean jobOpportunity;
    private Date endDate;
    private long remainingTimeInHours;
    private String remainingTimeFormatted;
    private Date createdAt;
    private String createdTimeFormatted;
    private Long totalViews;
}
