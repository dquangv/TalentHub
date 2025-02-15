package org.example.backend.service.intf.job;

import org.example.backend.dto.request.job.FreelancerJobDTORequest;
import org.example.backend.dto.response.job.FreelancerJobDTOResponse;
import org.example.backend.service.BaseService;

public interface FreelancerJobService extends BaseService<FreelancerJobDTORequest, FreelancerJobDTOResponse, Long> {
    FreelancerJobDTOResponse applyJob(FreelancerJobDTORequest request);
    FreelancerJobDTOResponse saveJob(FreelancerJobDTORequest request);
    FreelancerJobDTOResponse unSaveJob(FreelancerJobDTORequest request);
}
