package org.example.backend.mapper.job;

import org.example.backend.dto.request.job.PostJobsDTORequest;
import org.example.backend.dto.response.job.PostJobsDTOResponse;
import org.example.backend.entity.child.job.Job;
import org.example.backend.mapper.BaseMapper;
import org.example.backend.utils.TimeRemainingUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {TimeRemainingUtils.class})
public interface PostedJobsMapper extends BaseMapper<Job, PostJobsDTORequest, PostJobsDTOResponse> {

    @Mapping(source = "job.category.categoryTitle", target = "type")
    @Mapping(target = "applicants", expression = "java(countApplicants(job))")
    @Mapping(source = "job.createdAt", target = "postedDate")
    @Mapping(source = "job.endDate", target = "endDate")
    @Mapping(target = "remainingTimeInHours", expression = "java(TimeRemainingUtils.calculateRemainingTimeInHours(job.getEndDate()))")
    @Mapping(target = "remainingTimeFormatted", expression = "java(TimeRemainingUtils.getFormattedTimeRemaining(job.getEndDate()))")
    PostJobsDTOResponse toResponseDto(Job job);

    default Long countApplicants(Job job) {
        return job.getFreelancerJobs() != null ? (long) job.getFreelancerJobs().size() : 0L;
    }
}