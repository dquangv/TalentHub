package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.FreelancerJobDTORequest;
import org.example.backend.dto.response.account.freelancer.ApplicantResponseDTO;
import org.example.backend.dto.response.job.FreelancerJobDTOResponse;
import org.example.backend.dto.response.job.ViewJobDTOResponse;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.entity.child.job.Job;
import org.example.backend.enums.StatusFreelancerJob;
import org.example.backend.exception.BadRequestException;
import org.example.backend.mapper.job.FreelancerJobMapper;
import org.example.backend.repository.FreelancerJobRepository;
import org.example.backend.repository.FreelancerRepository;
import org.example.backend.repository.JobRepository;
import org.example.backend.service.intf.job.FreelancerJobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class FreelancerJobServiceImpl implements FreelancerJobService {
    private final FreelancerJobRepository freelancerJobRepository;
    private final FreelancerRepository freelancerRepository;
    private final JobRepository jobRepository;
    private final FreelancerJobMapper freelancerJobMapper;

    @Override
    public FreelancerJobDTOResponse create(FreelancerJobDTORequest freelancerJobDTORequest) {
        return null;
    }

    @Override
    public Optional<FreelancerJobDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<FreelancerJobDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }



    /*
    I should have combined these APIs into one and added a parameter.
    That would have been better.
    */

    @Override
    public FreelancerJobDTOResponse applyJob(FreelancerJobDTORequest request) {
        Optional<FreelancerJob> existingFreelancerJob = freelancerJobRepository.findByFreelancer_IdAndJob_Id(
                request.getFreelancerId(), request.getJobId());

        if (!existingFreelancerJob.isPresent()) {
            throw new BadRequestException("Freelancer Job Not Found");
        }

        FreelancerJob freelancerJob = existingFreelancerJob.get();
        freelancerJob.setStatus(StatusFreelancerJob.Applied);
        FreelancerJob updatedFreelancerJob = freelancerJobRepository.save(freelancerJob);

        return new FreelancerJobDTOResponse(
                updatedFreelancerJob.getId(),
                updatedFreelancerJob.getIsSaved(),
                updatedFreelancerJob.getStatus(),
                updatedFreelancerJob.getJob().getId(),
                updatedFreelancerJob.getFreelancer().getId()
        );
    }

    @Override
    public FreelancerJobDTOResponse saveJob(FreelancerJobDTORequest request) {
        Optional<FreelancerJob> existingFreelancerJob = freelancerJobRepository.findByFreelancer_IdAndJob_Id(
                request.getFreelancerId(), request.getJobId());

        if (!existingFreelancerJob.isPresent()) {
            throw new BadRequestException("Freelancer Job Not Found");
        }

        FreelancerJob freelancerJob = existingFreelancerJob.get();
        freelancerJob.setIsSaved(true);
        FreelancerJob updatedFreelancerJob = freelancerJobRepository.save(freelancerJob);

        return new FreelancerJobDTOResponse(
                updatedFreelancerJob.getId(),
                updatedFreelancerJob.getIsSaved(),
                updatedFreelancerJob.getStatus(),
                updatedFreelancerJob.getJob().getId(),
                updatedFreelancerJob.getFreelancer().getId()
        );
    }

    @Override
    public FreelancerJobDTOResponse unSaveJob(FreelancerJobDTORequest request) {
        Optional<FreelancerJob> existingFreelancerJob = freelancerJobRepository.findByFreelancer_IdAndJob_Id(
                request.getFreelancerId(), request.getJobId());

        if (!existingFreelancerJob.isPresent()) {
            throw new BadRequestException("Freelancer Job Not Found");
        }

        FreelancerJob freelancerJob = existingFreelancerJob.get();
        freelancerJob.setIsSaved(false);
        FreelancerJob updatedFreelancerJob = freelancerJobRepository.save(freelancerJob);

        return new FreelancerJobDTOResponse(
                updatedFreelancerJob.getId(),
                updatedFreelancerJob.getIsSaved(),
                updatedFreelancerJob.getStatus(),
                updatedFreelancerJob.getJob().getId(),
                updatedFreelancerJob.getFreelancer().getId()
        );
    }

    @Override
    public List<ApplicantResponseDTO> getApplicantByJobId(Long jobId) {
        return freelancerJobRepository.getApplicantByJobId(jobId)
                .stream()
                .map(freelancerJobMapper::toResponseDto).toList();
    }
}
