package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.ClientReviewDTORequest;
import org.example.backend.dto.request.job.FreelancerJobDTORequest;
import org.example.backend.dto.request.job.FreelancerReviewDTORequest;
import org.example.backend.dto.response.account.freelancer.ApplicantResponseDTO;
import org.example.backend.dto.response.job.ClientReviewDTOResponse;
import org.example.backend.dto.response.job.FreelancerJobDTOResponse;
import org.example.backend.dto.response.job.FreelancerReviewDTOResponse;
import org.example.backend.dto.response.job.SaveJobDTOResponse;
import org.example.backend.entity.child.account.client.Appointment;
import org.example.backend.entity.child.account.client.ClientReview;
import org.example.backend.entity.child.account.client.Company;
import org.example.backend.entity.child.account.freelancer.CV;
import org.example.backend.entity.child.account.freelancer.FreelancerReview;
import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.enums.StatusFreelancerJob;
import org.example.backend.exception.BadRequestException;
import org.example.backend.mapper.Account.freelancer.CreateFreelancerMapper;
import org.example.backend.mapper.job.ClientReviewMapper;
import org.example.backend.mapper.job.FreelancerJobMapper;
import org.example.backend.mapper.job.FreelancerReviewMapper;
import org.example.backend.mapper.job.SaveJobMapper;
import org.example.backend.repository.*;
import org.example.backend.service.impl.notify.NotifyService;
import org.example.backend.service.intf.job.FreelancerJobService;
import org.springframework.stereotype.Service;

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
    private final AppointmentRepository appointmentRepository;
    private final NotifyService notifyService;
    private final ClientReviewRepository clientReviewRepository;
    private final ClientReviewMapper clientReviewMapper;
    private final FreelancerReviewMapper freelancerReviewMapper;
    private final FreelancerReviewRepository freelancerReviewRepository;
    private final CVRepository cvRepository;


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
        CV cv = cvRepository.findById(request.getCvId()).orElse(null);

        freelancerJob.setCv(cv);
        FreelancerJob updatedFreelancerJob = freelancerJobRepository.save(freelancerJob);
        notifyService.sendNotification(request.getFreelancerId(), "Có một ứng viên đã ứng tuyển vào " + updatedFreelancerJob.getJob().getTitle(), "applicants/"+request.getJobId());
        return new FreelancerJobDTOResponse(
                updatedFreelancerJob.getId(),
                updatedFreelancerJob.getIsSaved(),
                updatedFreelancerJob.getStatus(),
                updatedFreelancerJob.getJob().getId(),
                updatedFreelancerJob.getFreelancer().getId(),
                updatedFreelancerJob.getCv().getUrl()
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
                updatedFreelancerJob.getFreelancer().getId(),
                updatedFreelancerJob.getCv().getUrl()
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
                updatedFreelancerJob.getFreelancer().getId(),
                updatedFreelancerJob.getCv().getUrl()
        );
    }
    @Override
    public Appointment getAppointmentByFreelancerJobId(Long freelancerJobId) {
        Optional<Appointment> appointment = appointmentRepository.findByFreelancerJobId(freelancerJobId);
        return appointment.orElse(null);
    }

    @Override
    public CV getCVByFreeLancer_IdAndJob_Id(Long freeLancerId, Long jobId) {
        if (freeLancerId == null || jobId == null) {
            throw new BadRequestException("Freelancer Job Id or Job Id Not Found");
        }

        CV cv = freelancerJobRepository.getCVByFreelancer_IdAndJob_Id(freeLancerId, jobId);

        return cv;
    }

    @Override
    public ClientReviewDTOResponse freelancerReview(Long freelancerJobId, ClientReviewDTORequest request) {
        if (freelancerJobId == null) {
            throw new BadRequestException("Freelancer Job Id Not Found");
        }

        if (request == null) {
            throw new BadRequestException("CLientReview Not Found");
        }

        if (request.getRating() == null) {
            throw new BadRequestException("Ratings Not Found");
        }

        if (request.getNote() == null) {
            throw new BadRequestException("Notes Not Found");
        }

        ClientReview review = clientReviewMapper.toEntity(request);
        review = clientReviewRepository.save(review);

        FreelancerJob freelancerJob = freelancerJobRepository.findById(freelancerJobId).get();
        freelancerJob.setClientReview(review);
        freelancerJobRepository.save(freelancerJob);

        return clientReviewMapper.toResponseDto(review);
    }

    @Override
    public FreelancerReviewDTOResponse clientReview(Long freelancerJobId, FreelancerReviewDTORequest request) {
        if (freelancerJobId == null) {
            throw new BadRequestException("Freelancer Job Id Not Found");
        }

        if (request == null) {
            throw new BadRequestException("CLientReview Not Found");
        }

        if (request.getRating() == null) {
            throw new BadRequestException("Ratings Not Found");
        }

        if (request.getNote() == null) {
            throw new BadRequestException("Notes Not Found");
        }

        FreelancerReview freelancerReview = freelancerReviewMapper.toEntity(request);
        freelancerReview = freelancerReviewRepository.save(freelancerReview);

        FreelancerJob freelancerJob = freelancerJobRepository.findById(freelancerJobId).get();
        freelancerJob.setFreelancerReview(freelancerReview);
        freelancerJobRepository.save(freelancerJob);

        return freelancerReviewMapper.toResponseDto(freelancerReview);
    }


    @Override
    public List<ApplicantResponseDTO> getApplicantByJobId(Long jobId) {
        List<FreelancerJob> results = freelancerJobRepository.getApplicantByJobId(jobId);

        return results.stream()
                .map(freelancerJob -> {
                    Appointment appointment = this.getAppointmentByFreelancerJobId(freelancerJob.getId());

                    return freelancerJobMapper.toResponseDto(freelancerJob, appointment == null ? -1 : appointment.getId());
                })
                .collect(Collectors.toList());
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
                updatedFreelancerJob.getFreelancer().getId(),
                updatedFreelancerJob.getCv().getUrl()
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
                updatedFreelancerJob.getFreelancer().getId(),
                updatedFreelancerJob.getCv().getUrl()
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
                updatedFreelancerJob.getFreelancer().getId(),
                updatedFreelancerJob.getCv().getUrl()
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
