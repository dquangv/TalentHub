package org.example.backend.mapper.job;

import org.example.backend.dto.request.job.FreelancerJobDTORequest;
import org.example.backend.dto.response.account.freelancer.ApplicantResponseDTO;
import org.example.backend.entity.child.account.client.Appointment;
import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.mapper.BaseMapper;
import org.example.backend.repository.AppointmentRepository;
import org.example.backend.service.intf.job.FreelancerJobService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface FreelancerJobMapper extends BaseMapper<FreelancerJob, FreelancerJobDTORequest, ApplicantResponseDTO> {

    @Mapping(source = "freelancerJob.freelancer.user.firstName", target = "firstName")
    @Mapping(source = "freelancerJob.freelancer.user.lastName", target = "lastName")
    @Mapping(source = "freelancerJob.freelancer.user.account.email", target = "email")
    @Mapping(source = "freelancerJob.freelancer.user.image", target = "image")
    @Mapping(expression = "java(mapPosition(freelancerJob))", target = "position")
    @Mapping(source = "freelancerJob.appliedDate", target = "appliedDate")
    @Mapping(source = "freelancerJob.status", target = "status")
    @Mapping(source = "freelancerJob.freelancer.id", target = "freelancerId")
    @Mapping(source = "freelancerJob.job.id", target = "jobId")
    @Mapping(source = "freelancerJob.cv.id", target = "cvId")
    @Mapping(expression = "java(mapCvURL(freelancerJob))", target = "cvURL")
    @Mapping(source = "freelancerJob.freelancerReview.rating", target = "rating", defaultValue = "0.0")
    @Mapping(target = "appointmentId", source = "appointmentId")
    ApplicantResponseDTO toResponseDto(FreelancerJob freelancerJob, Long appointmentId);

    default String mapPosition(FreelancerJob freelancerJob) {
        if (freelancerJob == null || freelancerJob.getFreelancer() == null
                || freelancerJob.getFreelancer().getExperiences() == null
                || freelancerJob.getFreelancer().getExperiences().isEmpty()) {
            return null;
        }
        return freelancerJob.getFreelancer().getExperiences().get(0).getPosition();
    }
    default String mapCvURL(FreelancerJob freelancerJob) {
        if (freelancerJob == null || freelancerJob.getCv() == null) {
            return null;
        }
        return freelancerJob.getCv().getUrl();
    }
}
