package org.example.backend.dto.response.cv;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.enums.StatusFreelancerJob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CVJobDTO {
    private Long jobId;
    private String jobTitle;
    private String companyName;
    private StatusFreelancerJob status;
}
