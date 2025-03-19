package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.repository.ClientRepository;
import org.example.backend.repository.FreelancerRepository;
import org.example.backend.repository.JobRepository;
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

    public Map<String, Object> getOverallStatistics() {
        Map<String, Object> statistics = new HashMap<>();

        try {
            long freelancerCount = freelancerRepository.count();
            long jobCount = jobRepository.count();
            long clientCount = clientRepository.count();

            statistics.put("freelancers", freelancerCount);
            statistics.put("jobs", jobCount);
            statistics.put("clients", clientCount);
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