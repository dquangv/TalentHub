package org.example.backend.service.intf.account.admin;

import org.example.backend.dto.response.account.admin.RevenueDTOResponse;

import java.util.List;

public interface RevenueService {
    List<RevenueDTOResponse> getRevenueByMonth(int year);
    List<RevenueDTOResponse> getRevenueByQuater(int year);
    List<RevenueDTOResponse> getRevenueByYear();
    List<RevenueDTOResponse> getRevenueBannerByMonth(int year);
    List<RevenueDTOResponse> getRevenueBannerByQuater(int year);
    List<RevenueDTOResponse> getRevenueBannerByYear();
}