package org.example.backend.mapper.job;

    import org.example.backend.dto.request.job.FreelancerJobDTORequest;
    import org.example.backend.dto.response.account.freelancer.ApplicantResponseDTO;
    import org.example.backend.entity.child.job.FreelancerJob;
    import org.example.backend.mapper.BaseMapper;
    import org.mapstruct.Mapper;
    import org.mapstruct.Mapping;
    import org.mapstruct.factory.Mappers;

    @Mapper(componentModel = "spring")
    public interface FreelancerJobMapper extends BaseMapper<FreelancerJob, FreelancerJobDTORequest, ApplicantResponseDTO> {
        FreelancerJobMapper INSTANCE = Mappers.getMapper(FreelancerJobMapper.class);

        @Mapping(source = "freelancer.user.firstName", target = "firstName")
        @Mapping(source = "freelancer.user.lastName", target = "lastName")
        @Mapping(source = "freelancer.user.account.email", target = "email")
        @Mapping(source = "freelancer.user.image", target = "image")
//        @Mapping(source = "freelancer.experiences.position", target = "position")
        @Mapping(source = "appliedDate", target = "appliedDate")
//        @Mapping(source = "status", target = "status")
        @Mapping(source = "freelancerReview.rating", target = "rating")
        ApplicantResponseDTO toResponseDto(FreelancerJob freelancerJob);
    }