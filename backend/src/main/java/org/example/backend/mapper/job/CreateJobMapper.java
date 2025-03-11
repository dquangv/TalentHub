package org.example.backend.mapper.job;

import org.example.backend.dto.request.job.CreateJobDTORequest;
import org.example.backend.dto.response.job.CreateJobDTOResponse;
import org.example.backend.entity.child.job.Job;
import org.example.backend.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface CreateJobMapper extends BaseMapper<Job, CreateJobDTORequest, CreateJobDTOResponse> {

    @Mapping(source = "clientId", target = "client.id")
    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "statusJob", target = "status")
    Job toEntity(CreateJobDTORequest createJobDTORequest);

    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "status", target = "statusJob")
    CreateJobDTOResponse toResponseDto(Job job);
}
