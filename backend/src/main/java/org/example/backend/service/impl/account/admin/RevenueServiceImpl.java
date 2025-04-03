package org.example.backend.service.impl.account.admin;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.response.account.admin.RevenueDTOResponse;
import org.example.backend.enums.RoleUser;
import org.example.backend.repository.*;
import org.example.backend.service.intf.account.AccountService;
import org.example.backend.service.intf.account.admin.RevenueService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RevenueServiceImpl implements RevenueService {
    private final RevenueRepository revenueRepository;
    private final AccountRepository accountRepository;
    private final JobRepository jobRepository;
    private final FreelancerJobRepository freelancerJobRepository;
    private final SoldPackageRepository soldPackageRepository;
    private final BannerRepository bannerRepository;

    @Override
    public List<RevenueDTOResponse> getRevenueByMonth(int year) {
        List<Object[]> results = revenueRepository.getRevenueByMonth(year);

        Map<Integer, Double> revenueMap = new HashMap<>();
        for (int month = 1; month <= 12; month++) {
            revenueMap.put(month, 0.0);
        }

        for (Object[] row : results) {
            Integer month = ((Number) row[0]).intValue();
            Double totalRevenue = row[1] != null ? ((Number) row[1]).doubleValue() : 0.0;
            revenueMap.put(month, totalRevenue);
        }

        return revenueMap.entrySet().stream()
                .map(entry -> new RevenueDTOResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RevenueDTOResponse> getRevenueByQuater(int year) {
        List<Object[]> results = revenueRepository.getRevenueByQuarter(year);

        Map<Integer, Double> revenueMap = new HashMap<>();
        for (int quarter = 1; quarter <= 4; quarter++) {
            revenueMap.put(quarter, 0.0);
        }

        for (Object[] row : results) {
            Integer quarter = ((Number) row[0]).intValue();
            Double totalRevenue = row[1] != null ? ((Number) row[1]).doubleValue() : 0.0;
            revenueMap.put(quarter, totalRevenue);
        }

        return revenueMap.entrySet().stream()
                .map(entry -> new RevenueDTOResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }


    @Override
    public List<RevenueDTOResponse> getRevenueByYear() {
        List<Object[]> result = revenueRepository.getRevenueByYear();

        return result.stream()
                .map(obj -> new RevenueDTOResponse((int) obj[0], (Double) obj[1]))
                .collect(Collectors.toList());
    }

    @Override
    public List<RevenueDTOResponse> getRevenueBannerByMonth(int year) {
        List<Object[]> results = revenueRepository.getRevenueBannerByMonth(year);

        Map<Integer, Double> revenueMap = new HashMap<>();
        for (int month = 1; month <= 12; month++) {
            revenueMap.put(month, 0.0);
        }

        for (Object[] row : results) {
            Integer month = ((Number) row[0]).intValue();
            Double totalRevenue = row[1] != null ? ((Number) row[1]).doubleValue() : 0.0;
            revenueMap.put(month, totalRevenue);
        }

        return revenueMap.entrySet().stream()
                .map(entry -> new RevenueDTOResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RevenueDTOResponse> getRevenueBannerByQuater(int year) {
        List<Object[]> results = revenueRepository.getRevenueBannerByQuarter(year);

        Map<Integer, Double> revenueMap = new HashMap<>();
        for (int quarter = 1; quarter <= 4; quarter++) {
            revenueMap.put(quarter, 0.0);
        }

        for (Object[] row : results) {
            Integer quarter = ((Number) row[0]).intValue();
            Double totalRevenue = row[1] != null ? ((Number) row[1]).doubleValue() : 0.0;
            revenueMap.put(quarter, totalRevenue);
        }

        return revenueMap.entrySet().stream()
                .map(entry -> new RevenueDTOResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }



    @Override
    public List<RevenueDTOResponse> getRevenueBannerByYear() {
        List<Object[]> result = revenueRepository.getRevenueBannerByYear();

        return result.stream()
                .map(obj -> new RevenueDTOResponse((int) obj[0], (Double) obj[1]))
                .collect(Collectors.toList());
    }

    public Map<String, Object> getGrowthRates() {
        LocalDateTime now = LocalDateTime.now();
        int currentYear = now.getYear();
        int currentMonth = now.getMonthValue();

        // Xác định tháng trước
        int previousYear = (currentMonth == 1) ? currentYear - 1 : currentYear;
        int previousMonth = (currentMonth == 1) ? 12 : currentMonth - 1;

        Map<String, Object> growthRates = new HashMap<>();

        try {

            // Đếm số freelancer và client trong tháng hiện tại
            Long currentFreelancers = accountRepository.countAccountsByRoleAndMonth(currentYear, currentMonth, RoleUser.FREELANCER);
            Long currentClients = accountRepository.countAccountsByRoleAndMonth(currentYear, currentMonth, RoleUser.CLIENT);
            Long currentJobs = jobRepository.countOpenJobsByMonth(currentMonth, currentYear);
            Long currentApprovedJobs = freelancerJobRepository.countApprovedFreelancerJobsByMonth(currentMonth, currentYear);
            Long currentAccounts = currentClients + currentFreelancers;
            Long currentSoldPackageRevenue = soldPackageRepository.countSumSoldPackageRevenue(currentYear, currentMonth);
            Long currentBannerRevenue = bannerRepository.countSumSoldPackageRevenue(currentYear, currentMonth);
            Long currentRevenue = currentBannerRevenue + currentSoldPackageRevenue;

            // Đếm số freelancer và client trong tháng trước
            Long previousFreelancers = accountRepository.countAccountsByRoleAndMonth(previousYear, previousMonth, RoleUser.FREELANCER);
            Long previousClients = accountRepository.countAccountsByRoleAndMonth(previousYear, previousMonth, RoleUser.CLIENT);
            Long previousJobs = jobRepository.countOpenJobsByMonth(previousMonth, previousYear);
            Long previousApprovedJobs = freelancerJobRepository.countApprovedFreelancerJobsByMonth(previousMonth, previousYear);
            Long previousAccounts = previousClients + previousFreelancers;
            Long previousSoldPackageRevenue = soldPackageRepository.countSumSoldPackageRevenue(previousYear, previousMonth);
            Long previousBannerRevenue = bannerRepository.countSumSoldPackageRevenue(previousYear, previousMonth);
            Long previousRevenue = previousBannerRevenue + previousSoldPackageRevenue;

            // Tính phần trăm thay đổi
            Double freelancerGrowth = calculateGrowthRate(currentFreelancers, previousFreelancers);
            Double clientGrowth = calculateGrowthRate(currentClients, previousClients);
            Double jobGrowth = calculateGrowthRate(currentJobs, previousJobs);
            Double approvedJobGrowth = calculateGrowthRate(currentApprovedJobs, previousApprovedJobs);
            Double accountGrowth = calculateGrowthRate(currentAccounts, previousAccounts);
            Double revenueGrowth = calculateGrowthRate(currentRevenue, previousRevenue);

            growthRates.put("freelancerGrowth", freelancerGrowth);
            growthRates.put("clientGrowth", clientGrowth);
            growthRates.put("jobGrowth", jobGrowth);
            growthRates.put("approvedJobGrowth", approvedJobGrowth);
            growthRates.put("accountGrowth", accountGrowth);
            growthRates.put("revenueGrowth", revenueGrowth);
            growthRates.put("success", true);

            return growthRates;

        } catch (Exception e) {
            growthRates.put("success", false);
            growthRates.put("error", "Error fetching statistics: " + e.getMessage());

            return growthRates;
        }
    }

    @Override
    public List<RevenueDTOResponse> getRevenueBannerByWeek(int year, int month) {
        List<Object[]> results = revenueRepository.getRevenueBannerByWeek(year, month);

        Map<Integer, Double> revenueMap = new HashMap<>();
        for (int week = 1; week <= 4; week++) {
            revenueMap.put(week, 0.0);
        }

        for (Object[] row : results) {
            Integer week = ((Number) row[0]).intValue();
            Double totalRevenue = row[1] != null ? ((Number) row[1]).doubleValue() : 0.0;
            revenueMap.put(week, totalRevenue);
        }

        return revenueMap.entrySet().stream()
                .map(entry -> new RevenueDTOResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RevenueDTOResponse> getRevenueByWeek(int year, int month) {
        List<Object[]> results = revenueRepository.getRevenueByWeek(year, month);

        Map<Integer, Double> revenueMap = new HashMap<>();
        for (int week = 1; week <= 4; week++) {
            revenueMap.put(week, 0.0);
        }

        for (Object[] row : results) {
            Integer week = ((Number) row[0]).intValue();
            Double totalRevenue = row[1] != null ? ((Number) row[1]).doubleValue() : 0.0;
            revenueMap.put(week, totalRevenue);
        }

        return revenueMap.entrySet().stream()
                .map(entry -> new RevenueDTOResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    private Double calculateGrowthRate(Long current, Long previous) {
        if (previous == 0) {
            return current > 0 ? 100.0 : 0.0;
        }
        return ((double) (current - previous) / previous) * 100;
    }
}
