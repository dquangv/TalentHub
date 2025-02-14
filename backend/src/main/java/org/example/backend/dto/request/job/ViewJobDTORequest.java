package org.example.backend.dto.request.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.enums.StatusFreelancerJob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewJobDTORequest {
    private long jobId;
    private long freelancerId;
}
