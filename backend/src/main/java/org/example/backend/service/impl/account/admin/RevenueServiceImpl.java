package org.example.backend.service.impl.account.admin;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.response.account.admin.RevenueDTOResponse;
import org.example.backend.repository.RevenueRepository;
import org.example.backend.service.intf.account.admin.RevenueService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RevenueServiceImpl implements RevenueService {
    private final RevenueRepository revenueRepository;

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
}
