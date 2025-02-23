package org.example.backend.mapper.job;

    import org.example.backend.dto.request.job.FreelancerJobDTORequest;
    import org.example.backend.dto.response.account.freelancer.ApplicantResponseDTO;
    import org.example.backend.entity.child.job.FreelancerJob;
    import org.example.backend.mapper.BaseMapper;
    import org.mapstruct.Mapper;
    import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
    public interface FreelancerJobMapper extends BaseMapper<FreelancerJob, FreelancerJobDTORequest, ApplicantResponseDTO> {

        @Mapping(source = "freelancer.user.firstName", target = "firstName")
        @Mapping(source = "freelancer.user.lastName", target = "lastName")
        @Mapping(source = "freelancer.user.account.email", target = "email")
        @Mapping(source = "freelancer.user.image", target = "image")
        @Mapping(target = "position", expression = "java(freelancerJob.getFreelancer().getExperiences().isEmpty() ?" +
                " null : freelancerJob.getFreelancer().getExperiences().get(0).getPosition())")
        @Mapping(source = "appliedDate", target = "appliedDate")
        @Mapping(source = "status", target = "status")
        @Mapping(source = "freelancerReview.rating", target = "rating")
        ApplicantResponseDTO toResponseDto(FreelancerJob freelancerJob);
    }