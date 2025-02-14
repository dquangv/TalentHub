package org.example.backend.controller.job.jobSkill;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.job.ViewJobDTORequest;
import org.example.backend.dto.response.job.ViewJobDTOResponse;
import org.example.backend.service.intf.job.ViewJobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jobs")
@RequiredArgsConstructor
public class ApplyJobController {
    private final ViewJobService viewJobService;

    @PostMapping("/view")
    public ResponseEntity<ResponseObject<ViewJobDTOResponse>> viewJob(@RequestBody ViewJobDTORequest viewJobDTORequest) {
        ViewJobDTOResponse viewJobDTOResponse = viewJobService.viewJob(viewJobDTORequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseObject.<ViewJobDTOResponse>builder()
                .message("Successfully save viewed job")
                .status(201)
                .data(viewJobDTOResponse)
                .build());
    }
}
