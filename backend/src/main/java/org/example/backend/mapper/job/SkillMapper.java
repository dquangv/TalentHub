package org.example.backend.mapper.job;

import org.example.backend.dto.request.job.SkillDTORequest;
import org.example.backend.dto.response.job.SkillDTOResponse;
import org.example.backend.entity.child.job.Skill;
import org.example.backend.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper extends BaseMapper<Skill, SkillDTORequest, SkillDTOResponse> {
}
