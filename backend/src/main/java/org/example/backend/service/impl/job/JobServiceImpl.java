package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.dto.request.job.CreateJobDTORequest;
import org.example.backend.dto.request.job.JobAdminDTOResponse;
import org.example.backend.dto.request.job.JobDTORequest;
import org.example.backend.dto.request.job.JobDetailDTORequest;
import org.example.backend.dto.response.account.freelancer.FreelancerDTOResponse;
import org.example.backend.dto.response.job.*;
import org.example.backend.dto.response.job.JobWithPackageDTOResponse;
import org.example.backend.entity.child.account.Account;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.entity.child.account.client.Company;
import org.example.backend.entity.child.account.client.SoldPackage;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.entity.child.job.*;
import org.example.backend.enums.*;
import org.example.backend.exception.BadRequestException;
import org.example.backend.mapper.Account.client.ClientMapper;
import org.example.backend.mapper.job.*;
import org.example.backend.repository.*;
import org.example.backend.service.impl.account.client.ClientServiceImpl;
import org.example.backend.service.impl.account.freelancer.FreelancerServiceImpl;
import org.example.backend.service.intf.job.JobService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Slf4j
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
    private final SoldPackageRepository soldPackageRepository;
    private final FreelancerRepository freelancerRepository;
    private final FreelancerServiceImpl freelancerServiceImpl;
    private final ClientServiceImpl clientServiceImpl;

    @Override
    @Transactional
    public JobDetailDTOResponse updateJob(Long id, JobDetailDTORequest jobDetailDTORequest) {
        if (!clientServiceImpl.checkValidClient(jobDetailDTORequest.getClientId())) {
            throw new BadRequestException("Client is banned");
        }

        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));


        Category category = categoryRepository.findById(jobDetailDTORequest.getCategoryId())
                .orElseThrow(() -> new BadRequestException("Category not found"));
        job.setCategory(category);

        job.setTitle(jobDetailDTORequest.getTitle());
        job.setScope(ScopeJob.valueOf(jobDetailDTORequest.getScope()));
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

        Long totalApplicants = freelancerJobRepository.countByJobAndStatus(job, StatusFreelancerJob.Applied);

        JobDetailDTOResponse jobDetailDTOResponse = jobDetailMapper.toResponseDto(job);
        jobDetailDTOResponse.setTotalApplicants(totalApplicants);

        return jobDetailDTOResponse;
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

        if (!clientServiceImpl.checkValidClient(createJobDTORequest.getClientId())) {
            throw new BadRequestException("Client is banned");
        }

        SoldPackage soldPackage = soldPackageRepository.findTopByClientIdAndStatusOrderByStartDateDesc(client.getId(), true);

        if (soldPackage == null) {
            throw new BadRequestException("Sold package not found");
        }

        Long numberPost = soldPackage.getNumberPost();
        Long numberPosted = soldPackage.getNumberPosted();

        if (numberPosted >= numberPost) {
            throw new BadRequestException("You have used up all your posts");
        }

        createJobDTORequest.setClientId(client.getId());

        Category category = categoryRepository.findById(createJobDTORequest.getCategoryId())
                .orElseThrow(() -> new BadRequestException("Category not found"));

        createJobDTORequest.setCategoryId(category.getId());

        Job job = createJobMapper.toEntity(createJobDTORequest);

        Long durationPost = soldPackage.getVoucherPackage().getDuration();

        job.setEndDate(Date.from(LocalDateTime.now().plusDays(durationPost).atZone(ZoneId.systemDefault()).toInstant()));

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

        soldPackage.setNumberPosted(soldPackage.getNumberPosted() + 1);
        soldPackageRepository.save(soldPackage);

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
//        Long inProgressQuantity = freelancerJobRepository.countByJobAndStatus(job, StatusFreelancerJob.InProgress);
        Long approvedQuantity = freelancerJobRepository.countByJobAndStatus(job, StatusFreelancerJob.Approved);
        Long rejectedQuantity = freelancerJobRepository.countByJobAndStatus(job, StatusFreelancerJob.Rejected);
        Long viewedQuantity = freelancerJobRepository.countByJobAndStatus(job, StatusFreelancerJob.Viewed);

        return jobAdminMapper.toResponseDto(job, appliedQuantity, cancelledQuantity,
                approvedQuantity, rejectedQuantity, viewedQuantity);
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

    /*@Override
    public List<JobDTOResponse> findAllJobs() {
        List<JobDTOResponse> jobs = jobRepository.findAll().stream()
                .filter(job -> job.getStatus() == StatusJob.POSTED)
                .map(job -> {
                    JobDTOResponse dto = jobMapper.toResponseDto(job);
                    Long clientId = job.getClient().getId();
                    companyRepository.getCompanyByClientId(clientId)
                            .ifPresent(company -> dto.setCompanyName(company.getCompanyName()));
                    return dto;
                })
                .collect(Collectors.toList());

        return jobs;
    }*/
    private final ClientMapper clientMapper;

    @Override
    public List<JobDTOResponse> findAllJobs(Long freelancerId) {
        List<JobDTOResponse> jobs = jobRepository.findOpenJobsWithNonBannedClients(StatusJob.OPEN, StatusAccount.BANNED).stream()
                .map(job -> {
                    JobDTOResponse dto = jobMapper.toResponseDto(job);
                    Long clientId = job.getClient().getId();
                    Optional<Client> byId = clientRepository.findById(clientId);
                    Client client = null;
                    if (byId.isPresent()) {
                        client = byId.get();
                        dto.setClient(clientMapper.toResponseDto(client));
                    }
                    companyRepository.getCompanyByClientId(clientId)
                            .ifPresent(company -> dto.setCompanyName(company.getCompanyName()));

                    boolean seen = freelancerJobRepository.existsByFreelancerIdAndJobId(freelancerId, job.getId());
                    boolean applied = freelancerJobRepository.existsByFreelancerIdAndJobIdAndStatus(
                            freelancerId, job.getId(), StatusFreelancerJob.Applied);
                    dto.setJobOpportunity(job.getJobOpportunity());
                    dto.setSeen(seen);
                    dto.setApplied(applied);
                    return dto;
                })
                .sorted(
                        Comparator.comparing(JobDTOResponse::isSeen)
                                .thenComparing(JobDTOResponse::getCreatedAt, Comparator.reverseOrder())
                )
                .collect(Collectors.toList());

        return jobs;
    }


    @Override
    public Optional<DetailJobDTOResponse> getDetailJobById(Long id) {
        try {
            Optional<Job> jobOpt = jobRepository.getDetailJobById(id);
            
            if (jobOpt.isPresent()) {
                Job job = jobOpt.get();
                List<FreelancerJob> appliedQuantity = freelancerJobRepository.findByJobId(job.getId()).stream().filter(item -> item.getStatus() != null && item.getStatus().equals(StatusFreelancerJob.Applied)).toList();

                DetailJobDTOResponse dto = detailJobMapper.toResponseDto(job);
                dto.setTotalApplicants(Long.valueOf(appliedQuantity.size()));
                /*Company company = companyRepository.getCompanyByClientId(job.getClient().getId())
                        .orElseThrow(() -> new RuntimeException("Company not found for client ID: " + job.getClient().getId()));
                dto.setCompanyName(company.getCompanyName());*/

                // company null allowed
                companyRepository.getCompanyByClientId(job.getClient().getId())
                        .ifPresent(company -> dto.setCompanyName(company.getCompanyName()));

                Long totalApplicants = freelancerJobRepository.countByJobAndStatus(job, StatusFreelancerJob.Applied);
                dto.setTotalApplicants(totalApplicants);

                Long totalViews = freelancerJobRepository.countViewsByJob(job);
                dto.setTotalViews(totalViews);

                return Optional.of(dto);
            }

            return Optional.empty();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<ApplyJobsDTOResponse> getApplyJobs(Long freeLancerId) {
        List<FreelancerJob> freelancerJobs = freelancerJobRepository.findFreelancerJobsByStatusAndFreelancerId(freeLancerId, StatusFreelancerJob.Applied, StatusFreelancerJob.Approved);
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

    @Override
    public List<JobWithPackageDTOResponse> getTop6JobsByTypePriority() {
        List<JobWithPackageDTOResponse> result = new ArrayList<>();
        Set<Long> usedClientIds = new HashSet<>();
        TypePackage[] priorityOrder = {TypePackage.DIAMOND, TypePackage.GOLD, TypePackage.SILVER, TypePackage.NORMAL};

        for (TypePackage type : priorityOrder) {
            if (result.size() >= 6) break;

            List<SoldPackage> soldPackages = soldPackageRepository.findByVoucherPackageType(type);
            for (SoldPackage sp : soldPackages) {
                if (result.size() >= 6) break;

                Long clientId = sp.getClient().getId();
                if (!usedClientIds.contains(clientId)) {
                    List<Job> jobsByClient = jobRepository.findByClientIdAndStatusNotBannedOrderByCreatedAtDesc(clientId, StatusAccount.BANNED);
                    for (Job job : jobsByClient) {
                        if (result.size() < 6) {
                            JobWithPackageDTOResponse dto = jobMapper.toResponseWithPackageDto(job, type);
                            result.add(dto);
                        } else {
                            break;
                        }
                    }
                    usedClientIds.add(clientId);
                }
            }
        }

        if (result.size() < 6) {
            List<Job> remainingJobs = jobRepository.findAllByOrderByCreatedAtDesc();
            for (Job job : remainingJobs) {
                if (!result.stream().anyMatch(dto -> dto.getId().equals(job.getId())) && result.size() < 6) {
                    JobWithPackageDTOResponse dto = jobMapper.toResponseWithPackageDto(job, TypePackage.NORMAL);
                    result.add(dto);
                }
                if (result.size() >= 6) break;
            }
        }

        return result;
    }
    public List<JobDTOResponse> getRecommendedJobsForFreelancer(Long freelancerId) {
        log.info("Start fetching recommended jobs for freelancerId: {}", freelancerId);

        Freelancer freelancer = freelancerRepository.findById(freelancerId)
                .orElseThrow(() -> {
                    log.error("Freelancer with ID {} not found", freelancerId);
                    return new BadRequestException("Freelancer not found");
                });

        Category freelancerCategory = freelancer.getCategory();
        Long categoryId = (freelancerCategory != null) ? freelancerCategory.getId() : null;
        log.info("Freelancer {} belongs to category ID: {}", freelancerId, categoryId);

        List<Job> recommendedJobs = jobRepository.findRecommendedJobsForFreelancer(categoryId, StatusAccount.BANNED);
        log.info("Found {} recommended jobs for category ID: {}", recommendedJobs.size(), categoryId);

        List<JobDTOResponse> result = recommendedJobs.stream()
                .limit(6)
                .map(job -> {
                    JobDTOResponse dto = jobMapper.toResponseDto(job);
                    boolean applied = freelancerJobRepository.existsByFreelancerIdAndJobIdAndStatus(
                            freelancerId, job.getId(), StatusFreelancerJob.Applied);
                    dto.setApplied(applied);

                    companyRepository.getCompanyByClientId(job.getClient().getId())
                            .ifPresent(company -> dto.setCompanyName(company.getCompanyName()));

                    return dto;
                })
                .collect(Collectors.toList());

        log.info("Returning {} recommended jobs for freelancer {}", result.size(), freelancerId);
        return result;
    }
    @Override
    public List<FreelancerDTOResponse> getFreelancersByClientJobCategories(Long clientId) {
        List<Job> clientJobs = jobRepository.findByClientId(clientId);
        Set<Long> categoryIds = clientJobs.stream()
                .filter(job -> job.getCategory() != null)
                .map(job -> job.getCategory().getId())
                .collect(Collectors.toSet());
        List<FreelancerDTOResponse> result = new ArrayList<>();
        for (Long categoryId : categoryIds) {
            List<FreelancerDTOResponse> freelancers = freelancerServiceImpl.getFreelancersByCategoryId(categoryId);
            result.addAll(freelancers);
            if (result.size() >= 6) break;
        }
        return result.stream()
                .distinct()
                .limit(6)
                .collect(Collectors.toList());
    }

    @Override
    public boolean closeJob(Long id){
        Optional<Job> job = jobRepository.findById(id);
        if (job.isPresent()) {
            job.get().setStatus(StatusJob.CLOSED);
            jobRepository.save(job.get());
            return true;
        }

        return false;
    }

}
