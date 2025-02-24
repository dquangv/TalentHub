package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.ViewJobDTORequest;
import org.example.backend.dto.response.job.ViewJobDTOResponse;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.entity.child.job.Job;
import org.example.backend.exception.BadRequestException;
import org.example.backend.repository.FreelancerJobRepository;
import org.example.backend.repository.FreelancerRepository;
import org.example.backend.repository.JobRepository;
import org.example.backend.service.intf.job.ViewJobService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ViewJobServiceImpl implements ViewJobService {
    private final FreelancerJobRepository freelancerJobRepository;
    private final FreelancerRepository freelancerRepository;
    private final JobRepository jobRepository;

    @Override
    public ViewJobDTOResponse viewJob(ViewJobDTORequest request) {
        // check if freelancer viewed this job or not
        Optional<FreelancerJob> existingFreelancerJob = freelancerJobRepository.findByFreelancer_IdAndJob_Id(
                request.getFreelancerId(), request.getJobId());

        if (existingFreelancerJob.isPresent()) {
            FreelancerJob freelancerJob = existingFreelancerJob.get();
            return new ViewJobDTOResponse(
                    freelancerJob.getId(),
                    freelancerJob.getIsSaved(),
                    freelancerJob.getStatus(),
                    freelancerJob.getJob().getId(),
                    freelancerJob.getFreelancer().getId()
            );
        }

        Freelancer freelancer = freelancerRepository.findById(request.getFreelancerId())
                .orElseThrow(() -> new BadRequestException("FreelancerId is not found"));
        Job job = jobRepository.findById(request.getJobId())
                .orElseThrow(() -> new BadRequestException("JobId is not found"));

        FreelancerJob newFreelancerJob = new FreelancerJob();
        newFreelancerJob.setFreelancer(freelancer);
        newFreelancerJob.setJob(job);
        newFreelancerJob.setIsSaved(false);

        FreelancerJob savedFreelancerJob = freelancerJobRepository.save(newFreelancerJob);

        return new ViewJobDTOResponse(
                savedFreelancerJob.getId(),
                savedFreelancerJob.getIsSaved(),
                savedFreelancerJob.getStatus(),
                savedFreelancerJob.getJob().getId(),
                savedFreelancerJob.getFreelancer().getId()
        );
    }
}
