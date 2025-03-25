package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.repository.ClientRepository;
import org.example.backend.repository.FreelancerRepository;
import org.example.backend.repository.JobRepository;
import org.example.backend.repository.FreelancerJobRepository; // Add this
import org.example.backend.enums.StatusJob;
import org.example.backend.enums.StatusFreelancerJob;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl {
    private final ClientRepository clientRepository;
    private final FreelancerRepository freelancerRepository;
    private final JobRepository jobRepository;
    private final FreelancerJobRepository freelancerJobRepository;

    public Map<String, Object> getOverallStatistics() {
        Map<String, Object> statistics = new HashMap<>();

        try {
            long clientCount = clientRepository.count();
            long freelancerCount = freelancerRepository.count();
            long totalAccounts = clientCount + freelancerCount;

            long postedJobsCount = jobRepository.countByStatus(StatusJob.POSTED);

            long approvedFreelancerJobsCount = freelancerJobRepository.countByStatus(StatusFreelancerJob.Approved);

            statistics.put("totalAccounts", totalAccounts);
            statistics.put("postedJobs", postedJobsCount);
            statistics.put("approvedFreelancerJobs", approvedFreelancerJobsCount);
            statistics.put("timestamp", LocalDateTime.now());
            statistics.put("success", true);

            return statistics;
        } catch (Exception e) {
            statistics.put("success", false);
            statistics.put("error", "Error fetching statistics: " + e.getMessage());
            return statistics;
        }
    }
}