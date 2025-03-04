package org.example.backend.service.intf.job;

import org.example.backend.dto.request.job.JobAdminDTOResponse;
import org.example.backend.dto.request.job.JobDTORequest;
import org.example.backend.dto.response.job.ApplyJobsDTOResponse;
import org.example.backend.dto.response.job.DetailJobDTOResponse;
import org.example.backend.dto.response.job.JobDTOResponse;
import org.example.backend.dto.response.job.PostJobsDTOResponse;
import org.example.backend.service.BaseService;

import java.util.List;
import java.util.Optional;

public interface JobService extends BaseService<JobDTORequest, JobDTOResponse, Long> {
    List<JobDTOResponse> findAllJobs();
    Optional<DetailJobDTOResponse> getDetailJobById(Long id);
    List<ApplyJobsDTOResponse> getApplyJobs(Long freeLancerId);
   List<PostJobsDTOResponse> getPostedJobs(Long clientId);
     List<JobAdminDTOResponse> getAllAdmin();
}
