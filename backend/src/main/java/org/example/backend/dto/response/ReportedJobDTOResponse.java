package org.example.backend.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.example.backend.dto.response.job.JobDTOResponse;
import org.example.backend.entity.child.job.Job;
import org.example.backend.enums.ReportedJobStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReportedJobDTOResponse {
    private Long id;
    private String jobTitle;
    private String reasonFreelancer;
    private String reasonAdmin;
    private String description;
    private ReportedJobStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long freelancerId;
    private Long jobId;
    private String fullName;
    private JobDTOResponse job;
    private String image;
}
