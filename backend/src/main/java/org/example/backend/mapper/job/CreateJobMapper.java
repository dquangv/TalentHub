package org.example.backend.mapper.job;

import org.example.backend.dto.request.job.CreateJobDTORequest;
import org.example.backend.dto.response.job.CreateJobDTOResponse;
import org.example.backend.entity.child.job.Job;
import org.example.backend.entity.child.job.JobSkill;
import org.example.backend.entity.child.job.Skill;
import org.example.backend.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreateJobMapper extends BaseMapper<Job, CreateJobDTORequest, CreateJobDTOResponse> {

    @Mapping(source = "clientId", target = "client.id")
    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(target = "jobSkills", expression = "java(mapJobSkills(request.getSkillId()))")
    @Mapping(source = "statusJob", target = "status")
    Job toEntity(CreateJobDTORequest request);

    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(target = "skillId", expression = "java(mapSkillIds(job.getJobSkills()))")
    @Mapping(source = "status", target = "statusJob")
    CreateJobDTOResponse toResponseDto(Job job);

    default List<Long> mapSkillIds(List<JobSkill> jobSkills) {
        return jobSkills == null ? List.of() : jobSkills.stream()
                .map(jobSkill -> jobSkill.getSkill().getId())
                .toList();
    }

    default List<JobSkill> mapJobSkills(List<Long> skillIds) {
        return skillIds == null ? List.of() : skillIds.stream()
                .map(skillId -> {
                    JobSkill jobSkill = new JobSkill();
                    Skill skill = new Skill();
                    skill.setId(skillId);
                    jobSkill.setSkill(skill);
                    return jobSkill;
                })
                .toList();
    }


}
