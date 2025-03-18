package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.CreateJobDTORequest;
import org.example.backend.dto.request.job.JobAdminDTOResponse;
import org.example.backend.dto.request.job.JobDTORequest;
import org.example.backend.dto.request.job.JobDetailDTORequest;
import org.example.backend.dto.response.job.*;
import org.example.backend.entity.child.account.Account;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.entity.child.account.client.Company;
import org.example.backend.entity.child.job.*;
import org.example.backend.enums.StatusFreelancerJob;
import org.example.backend.enums.StatusJob;
import org.example.backend.exception.BadRequestException;
import org.example.backend.mapper.job.*;
import org.example.backend.repository.*;
import org.example.backend.service.intf.job.JobService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    private final ClientRepository clientRepository;

    private final CategoryRepository categoryRepository;

    private final DetailJobMapper detailJobMapper;

    private final CompanyRepository companyRepository;

    private final FreelancerJobRepository freelancerJobRepository;

    private final ApplyJobsMapper applyJobsMapper;

    private final PostedJobsMapper postedJobsMapper;
    private final JobAdminMapper jobAdminMapper;

    private final JobSkillRepository jobSkillRepository;

    private final JobMapper jobMapper;

    private final CreateJobMapper createJobMapper;
    private final SkillRepository skillRepository;
    private final JobDetailMapper jobDetailMapper;

    @Override
    @Transactional
    public JobDetailDTOResponse updateJob(Long id, JobDetailDTORequest jobDetailDTORequest) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));


        Category category = categoryRepository.findById(jobDetailDTORequest.getCategoryId())
                .orElseThrow(() -> new BadRequestException("Category not found"));
        job.setCategory(category);

        job.setTitle(jobDetailDTORequest.getTitle());
        job.setScope(jobDetailDTORequest.getScope());
        job.setHourWork(jobDetailDTORequest.getHourWork());
        job.setDuration(jobDetailDTORequest.getDuration());
        job.setJobOpportunity(jobDetailDTORequest.getJobOpportunity());
        job.setFromPrice(jobDetailDTORequest.getFromPrice());
        job.setToPrice(jobDetailDTORequest.getToPrice());
        job.setTypePrice(jobDetailDTORequest.getTypePrice());
        job.setDescription(jobDetailDTORequest.getDescription());
        job.setTypePayment(jobDetailDTORequest.getTypePayment());
        job.setStatus(jobDetailDTORequest.getStatusJob());

        job.getJobSkills().clear();


        Job savedJob = jobRepository.save(job);
        List<Long> skillIds = jobDetailDTORequest.getSkillId();
        skillIds.forEach(skillId -> {
            Skill skill = skillRepository.findById(skillId)
                    .orElseThrow(() -> new BadRequestException("Skill id not found"));

            JobSkill jobSkill = new JobSkill();
            jobSkill.setSkill(skill);
            jobSkill.setJob(savedJob);

            jobSkillRepository.save(jobSkill);
        });
        return jobDetailMapper.toResponseDto(job);
    }



    @Override
    public JobDetailDTOResponse getJobById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        return jobDetailMapper.toResponseDto(job);
    }

    @Override
    public Boolean banJob(Long id) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isPresent()) {
            Job foundAccount = job.get();
            foundAccount.setStatus(StatusJob.BANNED);
            jobRepository.save(foundAccount);
            return true;
        }
        return false;
    }

    @Override
    public Boolean unBanJob(Long id) {
        Optional<Job> job = jobRepository.findById(id);
        if (job.isPresent()) {
            Job foundAccount = job.get();
            foundAccount.setStatus(StatusJob.OPEN);
            jobRepository.save(foundAccount);
            return true;
        }
        return false;
    }

    @Override
    public CreateJobDTOResponse createJob(CreateJobDTORequest createJobDTORequest) {

        Client client = clientRepository.findById(createJobDTORequest.getClientId())
                .orElseThrow(() -> new BadRequestException("Client not found"));

        createJobDTORequest.setClientId(client.getId());

        Category category = categoryRepository.findById(createJobDTORequest.getCategoryId())
                .orElseThrow(() -> new BadRequestException("Category not found"));

        createJobDTORequest.setCategoryId(category.getId());

        Job job = createJobMapper.toEntity(createJobDTORequest);

        Job savedJob = jobRepository.save(job);

        List<Long> skillIds = createJobDTORequest.getSkillId();

        skillIds.forEach(skillId -> {
            Skill skill = skillRepository.findById(skillId)
                    .orElseThrow(() -> new BadRequestException("Skilll id not found"));

            JobSkill jobSkill = new JobSkill();
            jobSkill.setSkill(skill);
            jobSkill.setJob(savedJob);

            jobSkillRepository.save(jobSkill);
        });
        return createJobMapper.toResponseDto(job);
    }

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
    public JobAdminDTOResponse getJobAdminDTOResponse(Job job) {
        Long appliedQuantity = freelancerJobRepository.countByJobAndStatus(job, StatusFreelancerJob.Applied);
        Long cancelledQuantity = freelancerJobRepository.countByJobAndStatus(job, StatusFreelancerJob.Cancelled);
        Long inProgressQuantity = freelancerJobRepository.countByJobAndStatus(job, StatusFreelancerJob.InProgress);
        Long viewedQuantity = freelancerJobRepository.countByJobAndStatus(job, StatusFreelancerJob.Viewed);

        return jobAdminMapper.toResponseDto(job, appliedQuantity, cancelledQuantity,
                inProgressQuantity, viewedQuantity);
    }

    @Override
    public List<JobAdminDTOResponse> getAllAdmin() {
        return jobRepository.findAll().stream().map(this::getJobAdminDTOResponse).toList();
    }

    @Override
    public Boolean deleteById(Long id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<JobDTOResponse> findAllJobs() {
        List<JobDTOResponse> jobs = jobRepository.findAll().stream()
                .map(job -> {
                    JobDTOResponse dto = jobMapper.toResponseDto(job);
                    Long clientId = job.getClient().getId();
                    companyRepository.getCompanyByClientId(clientId)
                            .ifPresent(company -> dto.setCompanyName(company.getCompanyName()));
                    return dto;
                })
                .collect(Collectors.toList());

        return jobs;
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
    public List<ApplyJobsDTOResponse> getApplyJobs(Long freeLancerId) {
        List<FreelancerJob> freelancerJobs = freelancerJobRepository.getApplyJobs(freeLancerId, StatusFreelancerJob.Applied);
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
