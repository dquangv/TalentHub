package org.example.backend.dto.response.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.enums.StatusFreelancerJob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewJobDTOResponse {
    private long id;
    private boolean isSaved;
    private StatusFreelancerJob status;
    private long jobId;
    private long freelancerId;
}
