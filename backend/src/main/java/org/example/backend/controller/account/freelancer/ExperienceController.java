package org.example.backend.controller.account.freelancer;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.account.freelancer.ExperienceDTORequest;
import org.example.backend.dto.response.account.freelancer.ExperienceDTOResponse;
import org.example.backend.service.intf.account.freelancer.ExperienceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/experiences")
@RequiredArgsConstructor
public class ExperienceController {
    private final ExperienceService experienceService;

    @PostMapping("")
    public ResponseEntity<ResponseObject<ExperienceDTOResponse>> create(@RequestBody ExperienceDTORequest experienceDTORequest) {
        ExperienceDTOResponse experienceDTOResponse = experienceService.create(experienceDTORequest);

        return ResponseEntity.ok(ResponseObject.<ExperienceDTOResponse>builder()
                .message("Successfully created a new experience")
                .status(HttpStatus.CREATED.value())
                .data(experienceDTOResponse)
                .build());
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<ResponseObject<ExperienceDTOResponse>> getById(@PathVariable Long id) {
        Optional<ExperienceDTOResponse> experienceDTOResponse = experienceService.getById(id);

        return ResponseEntity.ok(ResponseObject.<ExperienceDTOResponse>builder()
                .message("Successfully retrieved experience")
                .status(HttpStatus.OK.value())
                .data(experienceDTOResponse.get())
                .build());
    }*/

    @GetMapping("")
    public ResponseEntity<ResponseObject<List<ExperienceDTOResponse>>> getAll() {
        List<ExperienceDTOResponse> experiences = experienceService.getAll();

        return ResponseEntity.ok(ResponseObject.<List<ExperienceDTOResponse>>builder()
                .message("Successfully retrieved all experiences")
                .status(HttpStatus.OK.value())
                .data(experiences)
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject<Boolean>> deleteById(@PathVariable Long id) {
        Boolean deleted = experienceService.deleteById(id);

        return ResponseEntity.ok(ResponseObject.<Boolean>builder()
                .message("Successfully deleted experience with id: " + id)
                .status(HttpStatus.OK.value())
                .data(deleted)
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject<List<ExperienceDTOResponse>>> getAllByFreelancerId(@PathVariable Long id) {
        List<ExperienceDTOResponse> experiences = experienceService.getAllByFreelancerId(id);

        return ResponseEntity.ok(ResponseObject.<List<ExperienceDTOResponse>>builder()
                .message("Successfully get list experiences of freelancer: " + id)
                .status(HttpStatus.OK.value())
                .data(experiences)
                .build());
    }
}