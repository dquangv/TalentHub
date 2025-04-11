package org.example.backend.service.intf.account.freelancer;

import org.example.backend.dto.request.account.freelancer.ExperienceDTORequest;
import org.example.backend.dto.response.account.freelancer.ExperienceDTOResponse;
import org.example.backend.service.BaseService;

import java.util.List;

public interface ExperienceService extends BaseService<ExperienceDTORequest, ExperienceDTOResponse, Long> {
    List<ExperienceDTOResponse> getAllByFreelancerId(Long freelancerId);

    ExperienceDTOResponse update(Long id, ExperienceDTORequest experienceDTORequest);
}
