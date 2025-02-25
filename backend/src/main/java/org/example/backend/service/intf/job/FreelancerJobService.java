package org.example.backend.service.intf.job;

import org.example.backend.dto.request.job.FreelancerJobDTORequest;
import org.example.backend.dto.response.account.freelancer.ApplicantResponseDTO;
import org.example.backend.dto.response.job.FreelancerJobDTOResponse;
import org.example.backend.dto.response.job.SaveJobDTOResponse;
import org.example.backend.service.BaseService;

import java.util.List;

public interface FreelancerJobService extends BaseService<FreelancerJobDTORequest, FreelancerJobDTOResponse, Long> {
    FreelancerJobDTOResponse applyJob(FreelancerJobDTORequest request);
    FreelancerJobDTOResponse saveJob(FreelancerJobDTORequest request);
    FreelancerJobDTOResponse unSaveJob(FreelancerJobDTORequest request);
    List<ApplicantResponseDTO> getApplicantByJobId(Long jobId);
    FreelancerJobDTOResponse approveApplication(Long jobId, Long freelancerId);
    FreelancerJobDTOResponse rejectApplication(Long jobId, Long freelancerId);
    FreelancerJobDTOResponse unapplyJob(Long jobId, Long freelancerId);
    List<SaveJobDTOResponse> getSavedJobs(Long jobId);
}
