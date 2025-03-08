package org.example.backend.mapper.job;

import org.example.backend.dto.request.job.CreateJobDTORequest;
import org.example.backend.dto.request.job.JobDTORequest;
import org.example.backend.dto.response.job.CreateJobDTOResponse;
import org.example.backend.entity.child.job.Job;
import org.example.backend.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateJobMapper extends BaseMapper<Job, CreateJobDTORequest, CreateJobDTOResponse> {
}
