package org.example.backend.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportedJobDTOResponse {
    private Long id;
    private String reasonFreelancer;
    private String reasonAdmin;
    private String status;
    private String createdAt;
    private String updatedAt;
    private Long freelancerId;
    private Long jobId;
}
