package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.freelancer.CreateFreelancerDTORequest;
import org.example.backend.dto.request.job.FreelancerJobDTORequest;
import org.example.backend.dto.response.account.freelancer.ApplicantResponseDTO;
import org.example.backend.dto.response.account.freelancer.CreateFreelancerDTOResponse;
import org.example.backend.dto.response.job.FreelancerJobDTOResponse;
import org.example.backend.dto.response.job.SaveJobDTOResponse;
import org.example.backend.entity.child.account.User;
import org.example.backend.entity.child.account.client.Company;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.enums.StatusFreelancerJob;
import org.example.backend.exception.BadRequestException;
import org.example.backend.mapper.Freelancer.CreateFreelancerMapper;
import org.example.backend.mapper.job.FreelancerJobMapper;
import org.example.backend.mapper.job.SaveJobMapper;
import org.example.backend.repository.*;
import org.example.backend.service.intf.job.FreelancerJobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FreelancerJobServiceImpl implements FreelancerJobService {
    private final FreelancerJobRepository freelancerJobRepository;
    private final FreelancerRepository freelancerRepository;
    private final JobRepository jobRepository;
    private final UserRepository userRepository;
    private final FreelancerJobMapper freelancerJobMapper;
    private final SaveJobMapper saveJobMapper;
    private final CompanyRepository companyRepository;
    private final CreateFreelancerMapper createFreelancerMapper;


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
        List<FreelancerJob> results = freelancerJobRepository.getApplicantByJobId(jobId);

        return results.stream().map(freelancerJobMapper::toResponseDto).toList();
    }

    @Override
    public FreelancerJobDTOResponse approveApplication(Long jobId, Long freelancerId) {
        Optional<FreelancerJob> existingFreelancerJob = freelancerJobRepository.findByFreelancer_IdAndJob_Id(
                freelancerId, jobId);

        if (!existingFreelancerJob.isPresent()) {
            throw new BadRequestException("Freelancer Job Not Found");
        }

        FreelancerJob freelancerJob = existingFreelancerJob.get();

        if (freelancerJob.getStatus() != StatusFreelancerJob.Applied) {
            throw new BadRequestException("Can only approve applications with Applied status");
        }

        freelancerJob.setStatus(StatusFreelancerJob.InProgress);
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
    public FreelancerJobDTOResponse rejectApplication(Long jobId, Long freelancerId) {
        Optional<FreelancerJob> existingFreelancerJob = freelancerJobRepository.findByFreelancer_IdAndJob_Id(
                freelancerId, jobId);

        if (!existingFreelancerJob.isPresent()) {
            throw new BadRequestException("Freelancer Job Not Found");
        }

        FreelancerJob freelancerJob = existingFreelancerJob.get();

        if (freelancerJob.getStatus() != StatusFreelancerJob.Applied) {
            throw new BadRequestException("Can only reject applications with Applied status");
        }

        freelancerJob.setStatus(StatusFreelancerJob.Cancelled);
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
    public FreelancerJobDTOResponse unapplyJob(Long jobId, Long freelancerId) {
        Optional<FreelancerJob> existingFreelancerJob = freelancerJobRepository.findByFreelancer_IdAndJob_Id(
                freelancerId, jobId);

        if (!existingFreelancerJob.isPresent()) {
            throw new BadRequestException("Freelancer Job Not Found");
        }

        FreelancerJob freelancerJob = existingFreelancerJob.get();

        if (freelancerJob.getStatus() != StatusFreelancerJob.Applied) {
            throw new BadRequestException("Can only unapply from jobs with Applied status");
        }

        freelancerJob.setStatus(StatusFreelancerJob.Viewed);
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
    public List<SaveJobDTOResponse> getSavedJobs(Long freelancerId) {
        List<FreelancerJob> freelancerJobs = freelancerJobRepository.getSavedJobs(freelancerId);
        try {
            return freelancerJobs.stream()
                    .map(freelancerJob -> {
                        SaveJobDTOResponse dto = saveJobMapper.toResponseDto(freelancerJob);
                        Long id = freelancerJob.getJob().getClient().getId();
                        Company company = companyRepository.getCompanyByClientId(id)
                                .orElseThrow(() -> new RuntimeException("Company not found for client ID: " + id));
                        dto.setCompanyName(company.getCompanyName());
                        return dto;
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new BadRequestException("Error while fetching saved jobs");
        }
    }

    @Override
    public FreelancerJob findById(Long jobId) {
        if (jobId == null) {
            throw new BadRequestException("Job ID is null");
        }

        return freelancerJobRepository.findById(jobId).orElseThrow(() -> new BadRequestException("Job Not Found"));
    }


}
