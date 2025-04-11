package org.example.backend.mapper.Account.freelancer;

import org.example.backend.dto.request.account.freelancer.ExperienceDTORequest;
import org.example.backend.dto.response.account.freelancer.ExperienceDTOResponse;
import org.example.backend.entity.child.account.freelancer.Experience;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.exception.BadRequestException;
import org.example.backend.mapper.BaseMapper;
import org.example.backend.repository.FreelancerRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {FreelancerRepository.class})
public interface ExperienceMapper extends BaseMapper<Experience, ExperienceDTORequest, ExperienceDTOResponse> {

    @Mapping(target = "freelancer", expression = "java(mapFreelancerIdToFreelancer(dto.getFreelancerId(), freelancerRepository))")
    Experience toEntity(ExperienceDTORequest dto, @Context FreelancerRepository freelancerRepository);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "freelancer", source = "freelancer")
    ExperienceDTOResponse toResponseDto(Experience entity);

    default Freelancer mapFreelancerIdToFreelancer(Long freelancerId, FreelancerRepository freelancerRepository) {
        if (freelancerId == null) {
            throw new BadRequestException("freelancerId cannot be null");
        }

        return freelancerRepository.findById(freelancerId)
                .orElseThrow(() -> new BadRequestException("Freelancer not found with id: " + freelancerId));
    }
}