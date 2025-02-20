package org.example.backend.service.intf.job;

import org.example.backend.dto.request.job.SkillDTORequest;
import org.example.backend.dto.response.job.SkillDTOResponse;
import org.example.backend.service.BaseService;


public interface SkillService extends BaseService<SkillDTORequest, SkillDTOResponse, Long> {
    SkillDTOResponse update(Long id, SkillDTORequest skillDTORequest);
}
