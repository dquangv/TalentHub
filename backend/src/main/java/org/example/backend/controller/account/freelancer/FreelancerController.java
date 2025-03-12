package org.example.backend.controller.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.account.freelancer.CreateFreelancerDTORequest;
import org.example.backend.dto.request.account.freelancer.FreelancerDTORequest;
import org.example.backend.dto.request.account.freelancer.UpdateHourlyRateDTORequest;
import org.example.backend.dto.response.account.freelancer.*;
import org.example.backend.service.intf.account.freelancer.FreelancerDetailService;
import org.example.backend.service.intf.account.freelancer.FreelancerInfoService;
import org.example.backend.service.intf.account.freelancer.FreelancerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/freelancers")
@RequiredArgsConstructor
public class FreelancerController {

    private final FreelancerService freelancerService;
    private final FreelancerInfoService freelancerInfoService;
    private final FreelancerDetailService freelancerDetailService;

    @PostMapping("")
    public ResponseObject<FreelancerDTOResponse> createFreelancer(@RequestBody FreelancerDTORequest freelancerDTORequest) {
        FreelancerDTOResponse freelancerDTOResponse = freelancerService.create(freelancerDTORequest);
        return ResponseObject.<FreelancerDTOResponse>builder()
                .message("Freelancer created successfully")
                .status(HttpStatus.CREATED.value())
                .data(freelancerDTOResponse)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseObject<FreelancerDTOResponse> getFreelancerById(@PathVariable Long id) {
        return freelancerService.getById(id)
                .map(freelancerDTOResponse -> ResponseObject.<FreelancerDTOResponse>builder()
                        .message("Freelancer retrieved successfully")
                        .status(HttpStatus.OK.value())
                        .data(freelancerDTOResponse)
                        .build())
                .orElseGet(() -> ResponseObject.<FreelancerDTOResponse>builder()
                        .message("Freelancer not found")
                        .status(HttpStatus.NOT_FOUND.value())
                        .data(null)
                        .build());
    }

    @GetMapping("")
    public ResponseObject<List<FreelancerDTOResponse>> getAllFreelancers() {
        List<FreelancerDTOResponse> freelancerDTOResponses = freelancerService.getAll();
        return ResponseObject.<List<FreelancerDTOResponse>>builder()
                .message("All freelancers retrieved successfully")
                .status(HttpStatus.OK.value())
                .data(freelancerDTOResponses)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseObject<Void> deleteFreelancerById(@PathVariable Long id) {
        return freelancerService.deleteById(id)
                ? ResponseObject.<Void>builder()
                .message("Freelancer deleted successfully")
                .status(HttpStatus.NO_CONTENT.value())
                .data(null)
                .build()
                : ResponseObject.<Void>builder()
                .message("Freelancer not found")
                .status(HttpStatus.NOT_FOUND.value())
                .data(null)
                .build();
    }

    @GetMapping("/info")
    public ResponseObject<List<FreelancerInfoDTOResponse>> getAllFreelancerInfo() {
        List<FreelancerInfoDTOResponse> freelancers = freelancerInfoService.getAllFreelancerInfo();

        return ResponseObject.<List<FreelancerInfoDTOResponse>>builder()
                .message("Get all freelancer info successfully")
                .status(HttpStatus.OK.value())
                .data(freelancers)
                .build();
    }

    @GetMapping("/detail")
    public ResponseEntity<ResponseObject<FreelancerDetailDTOResponse>> getFreelancerDetailById(@RequestParam Long id) {
        FreelancerDetailDTOResponse freelancerDetailDTOResponse = freelancerDetailService.getFreelancerDetail(id);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseObject.<FreelancerDetailDTOResponse>builder()
                .message("Successfully get detail info of freelancer")
                .status(200)
                .data(freelancerDetailDTOResponse)
                .build());
    }

    @PostMapping("/createFreelancer")
    public ResponseEntity<ResponseObject<CreateFreelancerDTOResponse>> createFreelancer(@Valid @RequestBody CreateFreelancerDTORequest createFreelancerDTORequest) {
        CreateFreelancerDTOResponse freelancerDTOResponse = freelancerService.createProfile(createFreelancerDTORequest);

        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseObject.<CreateFreelancerDTOResponse>builder()
                        .message("Create freelancer Successfully")
                        .status(200)
                        .data(freelancerDTOResponse)
                        .build()
        );
    }
    @PostMapping("/updateHourlyRate")
    public ResponseEntity<ResponseObject<UpdateHourlyRateDTOResponse>> updateHourlyRate(@Valid @RequestBody UpdateHourlyRateDTORequest request) {
        UpdateHourlyRateDTOResponse response = freelancerService.updateHourlyRate(request);
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseObject.<UpdateHourlyRateDTOResponse>builder()
                        .message("Hourly rate updated successfully")
                        .status(HttpStatus.OK.value())
                        .data(response)
                        .build()
        );
    }
}

