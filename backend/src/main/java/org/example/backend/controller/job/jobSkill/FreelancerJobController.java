package org.example.backend.controller.job.jobSkill;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.job.FreelancerJobDTORequest;
import org.example.backend.dto.request.job.ViewJobDTORequest;
import org.example.backend.dto.response.job.FreelancerJobDTOResponse;
import org.example.backend.dto.response.job.ViewJobDTOResponse;
import org.example.backend.service.intf.job.FreelancerJobService;
import org.example.backend.service.intf.job.ViewJobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobs")
@RequiredArgsConstructor
public class FreelancerJobController {
    private final ViewJobService viewJobService;
    private final FreelancerJobService freelancerJobService;

    @PostMapping("/view")
    public ResponseEntity<ResponseObject<ViewJobDTOResponse>> viewJob(@RequestBody ViewJobDTORequest viewJobDTORequest) {
        ViewJobDTOResponse viewJobDTOResponse = viewJobService.viewJob(viewJobDTORequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseObject.<ViewJobDTOResponse>builder()
                .message("Successfully save viewed job")
                .status(200)
                .data(viewJobDTOResponse)
                .build());
    }

    @PatchMapping("/apply")
    public ResponseEntity<ResponseObject<FreelancerJobDTOResponse>> applyJob(@RequestBody FreelancerJobDTORequest freeJobDTORequest) {
        FreelancerJobDTOResponse freelancerJobDTOResponse = freelancerJobService.applyJob(freeJobDTORequest);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseObject.<FreelancerJobDTOResponse>builder()
                .message("Successfully applied for job")
                .status(200)
                .data(freelancerJobDTOResponse)
                .build());
    }

    @PatchMapping("/save")
    public ResponseEntity<ResponseObject<FreelancerJobDTOResponse>> saveJob(@RequestBody FreelancerJobDTORequest freeJobDTORequest) {
        FreelancerJobDTOResponse freelancerJobDTOResponse = freelancerJobService.saveJob(freeJobDTORequest);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseObject.<FreelancerJobDTOResponse>builder()
                .message("Successfully saved for job")
                .status(200)
                .data(freelancerJobDTOResponse)
                .build());
    }

    @PatchMapping("/unsave")
    public ResponseEntity<ResponseObject<FreelancerJobDTOResponse>> unSaveJob(@RequestBody FreelancerJobDTORequest freeJobDTORequest) {
        FreelancerJobDTOResponse freelancerJobDTOResponse = freelancerJobService.unSaveJob(freeJobDTORequest);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseObject.<FreelancerJobDTOResponse>builder()
                .message("Successfully unsaved for job")
                .status(200)
                .data(freelancerJobDTOResponse)
                .build());
    }
}
