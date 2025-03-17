package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.ReportedJobDTORequest;
import org.example.backend.dto.response.ReportedJobDTOResponse;
import org.example.backend.entity.child.ReportedJob;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.entity.child.job.Job;
import org.example.backend.exception.NotFoundException;
import org.example.backend.mapper.ReportedJobMapper;
import org.example.backend.repository.FreelancerRepository;
import org.example.backend.repository.JobRepository;
import org.example.backend.repository.ReportedJobRepository;
import org.example.backend.service.intf.ReportedJobService;
import org.example.backend.service.intf.image.CloudinaryImageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportedJobServiceImpl implements ReportedJobService {

    private final CloudinaryImageService cloudinaryImageService;
    @Override
    public List<ReportedJobDTOResponse> getByJobId(Long jobId) {

        List<ReportedJob> reportedJobs = reportedJobRepository.findByJobId(jobId);
        return reportedJobs.stream()
                .map(reportedJobMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportedJobDTOResponse> getByFreelancerId(Long freelancerId) {
        List<ReportedJob> reportedJobs = reportedJobRepository.findByFreelancerId(freelancerId);
        return reportedJobs.stream()
                .map(reportedJobMapper::toDTO)
                .collect(Collectors.toList());
    }

    private final ReportedJobRepository reportedJobRepository;
    private final ReportedJobMapper reportedJobMapper;
    private final FreelancerRepository freelancerRepository;
    private final JobRepository jobRepository;

    @Override
    public ReportedJobDTOResponse create(ReportedJobDTORequest request) {
        String imageUrl = cloudinaryImageService.uploadImage(request.getImage());

        Freelancer freelancer = freelancerRepository.findById(request.getFreelancerId())
                .orElseThrow(() -> new NotFoundException("Freelancer not found"));

        Job job = jobRepository.findById(request.getJobId())
                .orElseThrow(() -> new NotFoundException("Job not found"));

        ReportedJob reportedJob = new ReportedJob();
        reportedJob.setReasonAdmin(request.getReasonAdmin());
        reportedJob.setReasonFreelancer(request.getReasonFreelancer());
        reportedJob.setDescription(request.getDescription());
        reportedJob.setStatus(request.getStatus());
        reportedJob.setFreelancer(freelancer);
        reportedJob.setJob(job);
        reportedJob.setImage(imageUrl);
        ReportedJob savedReportedJob = reportedJobRepository.save(reportedJob);
        return reportedJobMapper.toDTO(savedReportedJob);
    }


    @Override
    public ReportedJobDTOResponse update(Long id, ReportedJobDTORequest request) {
        ReportedJob existingReportedJob = reportedJobRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reported Job not found"));

        existingReportedJob.setReasonAdmin(request.getReasonAdmin());
        existingReportedJob.setStatus(request.getStatus());

        ReportedJob updatedReportedJob = reportedJobRepository.save(existingReportedJob);
        return reportedJobMapper.toDTO(updatedReportedJob);
    }

    @Override
    public Optional<ReportedJobDTOResponse> getById(Long id) {
        Optional<ReportedJob> reportedJob = reportedJobRepository.findById(id);
        return reportedJob.map(reportedJobMapper::toDTO);
    }

    @Override
    public List<ReportedJobDTOResponse> getAll() {
        List<ReportedJob> reportedJobs = reportedJobRepository.findAll();
        return reportedJobs.stream()
                .map(reportedJobMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteById(Long id) {
        Optional<ReportedJob> reportedJob = reportedJobRepository.findById(id);
        if (reportedJob.isPresent()) {
            reportedJobRepository.delete(reportedJob.get());
            return true;
        }
        return false;
    }
}
