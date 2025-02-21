package org.example.backend.controller.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.response.account.AccountDTOResponse;
import org.example.backend.dto.response.job.JobDTOResponse;
import org.example.backend.service.intf.job.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/jobs")
public class JobController {

    private final JobService jobService;

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

}
