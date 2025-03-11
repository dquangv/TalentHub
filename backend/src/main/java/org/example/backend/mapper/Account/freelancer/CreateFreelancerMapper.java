package org.example.backend.mapper.Account.freelancer;

import org.example.backend.dto.request.account.freelancer.CreateFreelancerDTORequest;
import org.example.backend.dto.request.job.CreateJobDTORequest;
import org.example.backend.dto.response.account.freelancer.CreateFreelancerDTOResponse;
import org.example.backend.dto.response.job.CreateJobDTOResponse;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.entity.child.job.Job;
import org.example.backend.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateFreelancerMapper extends BaseMapper<Freelancer, CreateFreelancerDTORequest, CreateFreelancerDTOResponse> {

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "userId", target = "user.id")
    Freelancer toEntity(CreateFreelancerDTORequest createFreelancerDTORequest);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "user.id", target = "userId")
    CreateFreelancerDTOResponse toResponseDto(Freelancer freelancer);
}
