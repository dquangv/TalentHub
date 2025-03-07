package org.example.backend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportedJobDTORequest {
    private String reasonFreelancer;
    private String reasonAdmin;
    private String status;
    private Long freelancerId;
    private Long jobId;
}
