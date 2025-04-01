package org.example.backend.mapper.job;

import org.example.backend.dto.request.job.ApplyJobsDTORequest;
import org.example.backend.dto.response.job.ApplyJobsDTOResponse;
import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.mapper.BaseMapper;
import org.example.backend.utils.TimeRemainingUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {TimeRemainingUtils.class})
public interface ApplyJobsMapper extends BaseMapper<FreelancerJob, ApplyJobsDTORequest, ApplyJobsDTOResponse> {
    @Mapping(source = "job.id", target = "id")
    @Mapping(source = "job.title", target = "jobTitle")
    @Mapping(source = "job.category.categoryTitle", target = "jobType")
    @Mapping(source = "job.hourWork", target = "hourWork")
    @Mapping(source = "job.fromPrice", target = "fromPrice")
    @Mapping(source = "job.toPrice", target = "toPrice")
    @Mapping(source = "job.description", target = "description")
    @Mapping(expression = "java(mapSkillNames(freelancerJob))", target = "skillNames")
    @Mapping(source = "id", target="freelancerJobId")
    @Mapping(source = "job.endDate", target = "endDate")
    @Mapping(source = "appliedDate", target = "createdAt")
    @Mapping(target = "createdTimeFormatted", expression = "java(TimeRemainingUtils.getRelativeTimeFormatted(convertToDateViaInstant(freelancerJob.getAppliedDate())))")
    @Mapping(target = "remainingTimeInHours", expression = "java(TimeRemainingUtils.calculateRemainingTimeInHours(freelancerJob.getJob().getEndDate()))")
    @Mapping(target = "remainingTimeFormatted", expression = "java(TimeRemainingUtils.getFormattedTimeRemaining(freelancerJob.getJob().getEndDate()))")
    ApplyJobsDTOResponse toResponseDto(FreelancerJob freelancerJob);

    default List<String> mapSkillNames(FreelancerJob freelancerJob) {
        if (freelancerJob == null || freelancerJob.getJob().getJobSkills() == null || freelancerJob.getJob().getJobSkills().isEmpty()) {
            return Collections.emptyList();
        }
        return freelancerJob.getJob().getJobSkills().stream()
                .map(jobSkill -> jobSkill.getSkill().getSkillName())
                .collect(Collectors.toList());
    }

    default Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        if (dateToConvert == null) {
            return null;
        }
        return java.util.Date.from(dateToConvert.atZone(java.time.ZoneId.systemDefault()).toInstant());
    }
}