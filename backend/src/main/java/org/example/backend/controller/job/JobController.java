package org.example.backend.controller.job;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.job.ClientReviewDTORequest;
import org.example.backend.dto.request.job.CreateJobDTORequest;
import org.example.backend.dto.request.job.JobAdminDTOResponse;
import org.example.backend.dto.request.job.JobDetailDTORequest;
import org.example.backend.dto.response.account.StatusAccountDTOResponse;
import org.example.backend.dto.response.job.*;
import org.example.backend.dto.response.job.JobWithPackageDTOResponse;
import org.example.backend.entity.child.account.freelancer.CV;
import org.example.backend.entity.child.job.Job;
import org.example.backend.service.intf.job.FreelancerJobService;
import org.example.backend.service.intf.job.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.backend.dto.response.job.FreelancerJobDetailDTOResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/jobs")
public class JobController {

    private final JobService jobService;
    private final FreelancerJobService freelancerJobService;

    @PostMapping("/admin/ban")
    public ResponseObject<StatusAccountDTOResponse> banJob(@RequestParam Long jobId) {
        Boolean response = jobService.banJob(jobId);
        return ResponseObject
                .<StatusAccountDTOResponse>builder()
                .message("Ban job")
                .status(HttpStatus.OK.value())
                .data(StatusAccountDTOResponse.builder()
                        .status(response ? "Ban job successful" : "Ban job failed")
                        .build())
                .build();
    }

    @PostMapping("/admin/unban")
    public ResponseObject<StatusAccountDTOResponse> unBanJob(@RequestParam Long jobId) {
        Boolean response = jobService.unBanJob(jobId);
        return ResponseObject
                .<StatusAccountDTOResponse>builder()
                .message("UnBan job")
                .status(HttpStatus.OK.value())
                .data(StatusAccountDTOResponse.builder()
                        .status(response ? "Unban job successful" : "Unban job failed")
                        .build())
                .build();
    }

    @GetMapping
    public ResponseObject<List<JobDTOResponse>> findAllJobs(@RequestParam Long freelancerId) {
        List<JobDTOResponse> response = jobService.findAllJobs(freelancerId);
        return ResponseObject
                .<List<JobDTOResponse>>builder()
                .message("Get all job successful")
                .status(HttpStatus.OK.value())
                .data(response)
                .build();
    }

    @GetMapping("/admin")
    public ResponseObject<List<JobAdminDTOResponse>> findAllAdminJobs() {
        List<JobAdminDTOResponse> jobs = jobService.getAllAdmin();
        System.out.println(jobs.stream().count());
        return ResponseObject.<List<JobAdminDTOResponse>>builder()
                .message("Find all job by role admin")
                .status(HttpStatus.OK.value())
                .data(jobs)
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

    @GetMapping("/PostedJobs/{clientId}")
    public ResponseObject<List<PostJobsDTOResponse>> getPostedJobs(@PathVariable Long clientId) {
        List<PostJobsDTOResponse> response = jobService.getPostedJobs(clientId);
        return ResponseObject
                .<List<PostJobsDTOResponse>>builder()
                .message("Get all posted jobs successful")
                .status(HttpStatus.OK.value())
                .data(response)
                .build();
    }

    @PostMapping("/createJob")
    public ResponseObject<CreateJobDTOResponse> createJob(@RequestBody CreateJobDTORequest createJobDTORequest) {
        CreateJobDTOResponse createJobDTOResponse = jobService.createJob(createJobDTORequest);
        return ResponseObject
                .<CreateJobDTOResponse>builder()
                .message("Create job successful")
                .data(createJobDTOResponse)
                .status(HttpStatus.OK.value())
                .build();
    }

    @PostMapping("/getByID/{jobId}")
    public ResponseObject<JobDetailDTOResponse> getById(@PathVariable Long jobId) {
        JobDetailDTOResponse jobDetailDTOResponse = jobService.getJobById(jobId);
        return ResponseObject
                .<JobDetailDTOResponse>builder()
                .message("Get job by id successful")
                .data(jobDetailDTOResponse)
                .status(HttpStatus.OK.value())
                .build();
    }

    @PutMapping("/update/{jobId}")
    public ResponseObject<JobDetailDTOResponse> updateJob(
            @PathVariable Long jobId,
            @RequestBody JobDetailDTORequest jobDetailDTORequest) {

        JobDetailDTOResponse updatedJob = jobService.updateJob(jobId, jobDetailDTORequest);

        return ResponseObject
                .<JobDetailDTOResponse>builder()
                .message("Update job successful")
                .data(updatedJob)
                .status(HttpStatus.OK.value())
                .build();
    }

    @DeleteMapping("/{jobId}")
    public ResponseObject<Void> delete(
            @PathVariable Long jobId
           ) {

        Boolean status = jobService.deleteById(jobId);
        if (status){
            return ResponseObject
                    .<Void>builder()
                    .message("Delete job successful")
                    .status(HttpStatus.OK.value())
                    .build();
        }
        return ResponseObject
                .<Void>builder()
                .message("Delete job failed")
                .status(HttpStatus.OK.value())
                .build();

    }

    @GetMapping("/{freelancerId}/{jobId}/cv")
    public ResponseEntity<ResponseObject<CV>> getCVByFreelancerAndJob(
            @PathVariable("freelancerId") Long freelancerId,
            @PathVariable("jobId") Long jobId
    ) {
        CV cv = freelancerJobService.getCVByFreeLancer_IdAndJob_Id(freelancerId, jobId);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseObject.<CV>builder()
                .message("Successfully get CV")
                .status(200)
                .data(cv)
                .build());
    }

    @GetMapping("/freelancer-job/details/{freelancerId}")
    public ResponseObject<List<FreelancerJobDetailDTOResponse>> getFreelancerJobDetails(
            @PathVariable("freelancerId") Long freelancerId) {
        List<FreelancerJobDetailDTOResponse> detailsList = freelancerJobService.getJobDetailsByFreelancerId(freelancerId);

        return ResponseObject.<List<FreelancerJobDetailDTOResponse>>builder()
                .message(detailsList != null && !detailsList.isEmpty() ? "Get freelancer job details successful" : "No jobs found for this freelancer")
                .status(detailsList != null && !detailsList.isEmpty() ? HttpStatus.OK.value() : HttpStatus.OK.value())
                .data(detailsList)
                .build();
    }

    @GetMapping("/top-6")
    public ResponseObject<List<JobWithPackageDTOResponse>> getTop6JobsWithPackage() {
        List<JobWithPackageDTOResponse> jobs = jobService.getTop6JobsByTypePriority();
        return ResponseObject.<List<JobWithPackageDTOResponse>>builder()
                .status(200)
                .message("Top 6 jobs with package type retrieved successfully")
                .data(jobs)
                .build();
    }

}
