package org.example.backend.mapper.job;

import org.example.backend.dto.request.job.PostJobsDTORequest;
import org.example.backend.dto.response.job.PostJobsDTOResponse;
import org.example.backend.entity.child.job.Job;
import org.example.backend.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Mapper(componentModel = "spring")
public interface PostedJobsMapper extends BaseMapper<Job, PostJobsDTORequest,PostJobsDTOResponse> {

    @Mapping(source = "job.category.categoryTitle", target = "type")
    @Mapping(target = "applicants", expression = "java(countApplicants(job))")
    @Mapping(source = "job.createdAt", target = "postedDate")
    @Mapping(source = "job.endDate", target = "endDate")
    @Mapping(target = "remainingTimeInHours", expression = "java(calculateRemainingTimeInHours(job))")
    @Mapping(target = "remainingTimeFormatted", expression = "java(formatRemainingTime(job))")
    PostJobsDTOResponse toResponseDto(Job job);

    default Long countApplicants(Job job) {
        return job.getFreelancerJobs() != null ? (long) job.getFreelancerJobs().size() : 0L;
    }

    default long calculateRemainingTimeInHours(Job job) {
        if (job.getEndDate() == null) {
            return 0;
        }

        Date now = new Date();
        Date endDate = job.getEndDate();

        if (now.after(endDate)) {
            return 0;
        }

        long diffInMillis = endDate.getTime() - now.getTime();
        return TimeUnit.MILLISECONDS.toHours(diffInMillis);
    }

    default String formatRemainingTime(Job job) {
        long hours = calculateRemainingTimeInHours(job);

        if (hours <= 0) {
            return "Đã hết hạn";
        }

        long days = hours / 24;
        long remainingHours = hours % 24;

        if (days > 0) {
            return days + " ngày " + remainingHours + " giờ";
        } else {
            return remainingHours + " giờ";
        }
    }
}