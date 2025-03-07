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
            @Mapping(source = "createdAt", target = "createdAt"),
            @Mapping(source = "updatedAt", target = "updatedAt"),
            @Mapping(source = "status", target = "status")
    })
    ReportedJobDTOResponse toDTO(ReportedJob reportedJob);

    @Mappings({
            @Mapping(source = "freelancerId", target = "freelancer.id"),
            @Mapping(source = "jobId", target = "job.id"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "description", target = "description")

    })
    ReportedJob toEntity(ReportedJobDTORequest reportedJobDTORequest);
}
