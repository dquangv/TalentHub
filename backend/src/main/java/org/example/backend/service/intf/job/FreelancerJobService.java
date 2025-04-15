package org.example.backend.service.intf.job;

import org.example.backend.dto.request.account.freelancer.CreateFreelancerDTORequest;
import org.example.backend.dto.request.job.ClientReviewDTORequest;
import org.example.backend.dto.request.job.FreelancerJobDTORequest;
import org.example.backend.dto.request.job.FreelancerReviewDTORequest;
import org.example.backend.dto.response.account.freelancer.ApplicantResponseDTO;
import org.example.backend.dto.response.account.freelancer.CreateFreelancerDTOResponse;
import org.example.backend.dto.response.job.ClientReviewDTOResponse;
import org.example.backend.dto.response.job.FreelancerJobDTOResponse;
import org.example.backend.dto.response.job.FreelancerReviewDTOResponse;
import org.example.backend.dto.response.job.SaveJobDTOResponse;
import org.example.backend.entity.child.account.client.Appointment;
import org.example.backend.entity.child.account.client.ClientReview;
import org.example.backend.entity.child.account.freelancer.CV;
import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.service.BaseService;
import org.example.backend.dto.response.job.FreelancerJobDetailDTOResponse;

import java.util.List;

public interface FreelancerJobService extends BaseService<FreelancerJobDTORequest, FreelancerJobDTOResponse, Long> {
    FreelancerJobDTOResponse applyJob(FreelancerJobDTORequest request);

    FreelancerJobDTOResponse saveJob(FreelancerJobDTORequest request);

    FreelancerJobDTOResponse unSaveJob(FreelancerJobDTORequest request);

    List<ApplicantResponseDTO> getApplicantByJobId(Long jobId);

    FreelancerJobDTOResponse approveApplication(Long jobId, Long freelancerId);

    FreelancerJobDTOResponse rejectApplication(Long jobId, Long freelancerId);

    FreelancerJobDTOResponse unapplyJob(Long jobId, Long freelancerId);

    List<SaveJobDTOResponse> getSavedJobs(Long freelancerId);

    FreelancerJob findById(Long jobId);

    public Appointment getAppointmentByFreelancerJobId(Long freelancerJobId);

    CV getCVByFreeLancer_IdAndJob_Id(Long freeLancerId, Long jobId);

    ClientReviewDTOResponse freelancerReview(Long freelancerJobId, ClientReviewDTORequest request);

    FreelancerReviewDTOResponse clientReview(Long freelancerJobId, FreelancerReviewDTORequest request);

    List<FreelancerJobDetailDTOResponse> getJobDetailsByFreelancerId(Long freelancerId);
}
