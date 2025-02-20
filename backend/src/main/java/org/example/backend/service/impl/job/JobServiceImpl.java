package org.example.backend.service.impl.job;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.job.JobDTORequest;
import org.example.backend.dto.response.job.JobDTOResponse;
import org.example.backend.mapper.job.JobMapper;
import org.example.backend.repository.JobRepository;
import org.example.backend.service.intf.job.JobService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;


@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    private final JobMapper jobMapper;

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

            if (jobs.isEmpty()) {
                throw new RuntimeException("Jobs is empty");
            }
            return jobs;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
