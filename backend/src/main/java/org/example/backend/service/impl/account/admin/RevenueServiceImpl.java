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
        List<Object[]> result = revenueRepository.getRevenueByMonth(year);

        return result.stream()
                .map(obj -> new RevenueDTOResponse((int) obj[0], (Double) obj[1]))
                .collect(Collectors.toList());
    }

    @Override
    public List<RevenueDTOResponse> getRevenueByQuater(int year) {
        List<Object[]> result = revenueRepository.getRevenueByQuarter(year);

        return result.stream()
                .map(obj -> {
                    Integer quarter = ((Number) obj[0]).intValue();
                    Double totalRevenue = obj[1] != null ? ((Number) obj[1]).doubleValue() : 0.0;
                    return new RevenueDTOResponse(quarter, totalRevenue);
                })
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

        return results.stream()
                .map(row -> new RevenueDTOResponse((int) row[0], (Double) row[1]))
                .collect(Collectors.toList());
    }

    @Override
    public List<RevenueDTOResponse> getRevenueBannerByQuater(int year) {
        List<Object[]> results = revenueRepository.getRevenueBannerByQuarter(year);

        return results.stream()
                .map(row -> {
                    Integer quarter = ((Number) row[0]).intValue();
                    Double totalRevenue = row[1] != null ? ((Number) row[1]).doubleValue() : 0.0;
                    return new RevenueDTOResponse(quarter, totalRevenue);
                })
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

    private Double calculateGrowthRate(Long current, Long previous) {
        if (previous == 0) {
            return current > 0 ? 100.0 : 0.0;
        }
        return ((double) (current - previous) / previous) * 100;
    }
}
