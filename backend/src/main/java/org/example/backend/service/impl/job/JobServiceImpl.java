package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.JobDTORequest;
import org.example.backend.dto.response.job.*;
import org.example.backend.entity.child.account.client.Company;
import org.example.backend.entity.child.job.FreelancerJob;
import org.example.backend.entity.child.job.Job;
import org.example.backend.enums.StatusFreelancerJob;
import org.example.backend.exception.BadRequestException;
import org.example.backend.mapper.job.ApplyJobsMapper;
import org.example.backend.mapper.job.DetailJobMapper;
import org.example.backend.mapper.job.JobMapper;
import org.example.backend.mapper.job.PostedJobsMapper;
import org.example.backend.repository.CompanyRepository;
import org.example.backend.repository.FreelancerJobRepository;
import org.example.backend.repository.JobRepository;
import org.example.backend.service.intf.job.JobService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;


    private final DetailJobMapper detailJobMapper;

    private final CompanyRepository companyRepository;

    private final FreelancerJobRepository freelancerJobRepository;

    private final ApplyJobsMapper applyJobsMapper;

    private final PostedJobsMapper postedJobsMapper;

    @Override
    public JobDTOResponse create(JobDTORequest jobDTORequest) {
        return null;
    }

    @Override
    public Optional<JobDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<JobDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }

    @Override
    public List<JobDTOResponse> findAllJobs() {
        try {
            List<Object[]> results = jobRepository.findAllJobsNative();
            List<JobDTOResponse> jobs = results.stream().map(obj -> new JobDTOResponse(
                    ((Number) obj[0]).longValue(),
                    (String) obj[1],
                    (String) obj[2],
                    (BigDecimal) obj[3],
                    (BigDecimal) obj[4],
                    (BigDecimal) obj[5],
                    (String) obj[6],
                    (String) obj[7]  // Đây là chuỗi kết quả của GROUP_CONCAT
            )).toList();

            return jobs;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<DetailJobDTOResponse> getDetailJobById(Long id) {
        try {
            Optional<Job> jobOpt = jobRepository.getDetailJobById(id);
            if (jobOpt.isPresent()) {
                Job job = jobOpt.get();
                DetailJobDTOResponse dto = detailJobMapper.toResponseDto(job);
                Company company = companyRepository.getCompanyByClientId(job.getClient().getId())
                        .orElseThrow(() -> new RuntimeException("Company not found for client ID: " + job.getClient().getId()));
                dto.setCompanyName(company.getCompanyName());
                return Optional.of(dto);
            }
            return Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<ApplyJobsDTOResponse> getApplyJobs(Long jobId) {
        List<FreelancerJob> freelancerJobs = freelancerJobRepository.getApplyJobs(jobId, StatusFreelancerJob.Applied);
        try {
            return freelancerJobs.stream()
                    .map(freelancerJob -> {
                        ApplyJobsDTOResponse dto = applyJobsMapper.toResponseDto(freelancerJob);
                        Long id = freelancerJob.getJob().getClient().getId();
                        Company company = companyRepository.getCompanyByClientId(id)
                                .orElseThrow(() -> new RuntimeException("Company not found for client ID: " + id));
                        dto.setCompanyName(company.getCompanyName());
                        return dto;
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new BadRequestException("Error while fetching apply jobs");
        }
    }
    public List<PostJobsDTOResponse> getPostedJobs(Long clientId) {
        return jobRepository.getPostedJobs(clientId).stream().map(postedJobsMapper::toResponseDto).collect(toList());
    }
}
