package org.example.backend.mapper.job;

import org.example.backend.dto.request.job.DetailJobDTORequest;
import org.example.backend.dto.response.job.DetailJobDTOResponse;
import org.example.backend.entity.child.job.Job;
import org.example.backend.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface DetailJobMapper extends BaseMapper<Job, DetailJobDTORequest, DetailJobDTOResponse> {

    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "client.user.firstName", target = "firstName")
    @Mapping(source = "client.user.lastName", target = "lastName")
    @Mapping(source = "category.categoryTitle", target = "type")
    @Mapping(expression = "java(mapSkillNames(job))", target = "skillNames")
    DetailJobDTOResponse toResponseDto(Job job);

    default List<String> mapSkillNames(Job job) {
        if (job == null || job.getJobSkills() == null || job.getJobSkills().isEmpty()) {
            return Collections.emptyList();
        }
        return job.getJobSkills().stream()
                .map(jobSkill -> jobSkill.getSkill().getSkillName())
                .collect(Collectors.toList());
    }
}