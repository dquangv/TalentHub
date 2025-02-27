package org.example.backend.controller.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.response.account.AccountDTOResponse;
import org.example.backend.dto.response.job.*;
import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.service.intf.job.FreelancerJobService;
import org.example.backend.service.intf.job.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/jobs")
public class JobController {

    private final JobService jobService;
    private final FreelancerJobService freelancerJobService;

    @GetMapping
    public ResponseObject<List<JobDTOResponse>> findAllJobs() {
        List<JobDTOResponse> response = jobService.findAllJobs();
        return ResponseObject
                .<List<JobDTOResponse>>builder()
                .message("Get all job successful")
                .status(HttpStatus.OK.value())
                .data(response)
                .build();
    }

    @GetMapping("/detail-job/{id}")
    public ResponseObject<DetailJobDTOResponse> getDetailJob(@PathVariable Long id) {
        DetailJobDTOResponse detailJobDTO = jobService.getDetailJobById(id).orElse(null);

        return ResponseObject.<DetailJobDTOResponse>builder()
                .message(detailJobDTO != null ? "Get detail job successful" : "Job not found")
                .status(detailJobDTO != null ? HttpStatus.OK.value() : HttpStatus.NOT_FOUND.value())
                .data(detailJobDTO)
                .build();
    }

    @GetMapping("/SavedJobs/{jobId}")
    public ResponseObject<List<SaveJobDTOResponse>> getSaveJobs(@PathVariable Long jobId) {
        List<SaveJobDTOResponse> response = freelancerJobService.getSavedJobs(jobId);
        return ResponseObject
                .<List<SaveJobDTOResponse>>builder()
                .message("Get all saved job successful")
                .status(HttpStatus.OK.value())
                .data(response)
                .build();

    }
    @GetMapping("/ApplyJobs/{freeLancerId}")
    public ResponseObject<List<ApplyJobsDTOResponse>> getApplyJobs(@PathVariable Long freeLancerId) {
        List<ApplyJobsDTOResponse> response = jobService.getApplyJobs(freeLancerId);
        return ResponseObject
                .<List<ApplyJobsDTOResponse>>builder()
                .message("Get all apply job successful")
                .status(HttpStatus.OK.value())
                .data(response)
                .build();
    }
    @GetMapping("/PostedJobs/{jobId}")
    public ResponseObject<List<PostJobsDTOResponse>> getPostedJobs(@PathVariable Long jobId) {
        List<PostJobsDTOResponse> response = jobService.getPostedJobs(jobId);
        return ResponseObject
                .<List<PostJobsDTOResponse>>builder()
                .message("Get all apply job successful")
                .status(HttpStatus.OK.value())
                .data(response)
                .build();
    }

}
