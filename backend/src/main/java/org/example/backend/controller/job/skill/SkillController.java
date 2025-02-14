package org.example.backend.controller.job.skill;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.job.SkillDTORequest;
import org.example.backend.dto.response.job.SkillDTOResponse;
import org.example.backend.service.intf.job.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/skills")
@RequiredArgsConstructor
public class SkillController {
    private final SkillService skillService;

    @PostMapping("")
    public ResponseEntity<ResponseObject<SkillDTOResponse>> createSkill(@RequestBody SkillDTORequest skillDTORequest) {
        SkillDTOResponse skillDTOResponse = skillService.create(skillDTORequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseObject.<SkillDTOResponse>builder()
                .message("Successfully created skill")
                .status(201)
                .data(skillDTOResponse)
                .build());
    }
}
