package org.example.backend.mapper.job;

import org.example.backend.dto.request.job.JobDTORequest;
import org.example.backend.dto.response.job.JobDTOResponse;
import org.example.backend.entity.child.job.Job;
import org.example.backend.entity.child.job.JobSkill;
import org.example.backend.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobMapper extends BaseMapper<Job, JobDTORequest, JobDTOResponse> {

//    @Mapping(target = "companyName", source = "job.client.company.companyName")
//    @Mapping(target = "statusJob", source = "status")
    @Mapping(target = "skillName", expression = "java(mapSkills(job.getJobSkills()))")
    @Mapping(target = "categoryName", source = "category.categoryTitle")
    JobDTOResponse toResponseDto(Job job);


    default List<String> mapSkills(List<JobSkill> jobSkills) {
        if (jobSkills == null || jobSkills.isEmpty()) {
            return List.of(); // Return an empty list if there are no skills
        }
        return jobSkills.stream()
                .map(js -> js.getSkill().getSkillName()) // Get skill name from `Skill`
                .toList(); // Collect to a list
    }
}
