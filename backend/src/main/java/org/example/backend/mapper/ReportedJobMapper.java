package org.example.backend.mapper;

import org.example.backend.dto.request.ReportedJobDTORequest;
import org.example.backend.dto.response.ReportedJobDTOResponse;
import org.example.backend.entity.child.ReportedJob;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ReportedJobMapper {

    @Mappings({
            @Mapping(source = "freelancer.id", target = "freelancerId"),
            @Mapping(source = "job.id", target = "jobId"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "job.title", target = "jobTitle"),
            @Mapping(source = "job", target = "job"),
            @Mapping(target = "fullName", expression = "java(reportedJob.getFreelancer().getUser().getFirstName() + \" \" + reportedJob.getFreelancer().getUser().getLastName())")
    })
    ReportedJobDTOResponse toDTO(ReportedJob reportedJob);


}
