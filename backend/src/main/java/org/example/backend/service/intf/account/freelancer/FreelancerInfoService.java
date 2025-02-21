package org.example.backend.service.intf.account.freelancer;

import org.example.backend.dto.response.account.freelancer.FreelancerInfoDTOResponse;

import java.util.List;

public interface FreelancerInfoService {
    List<FreelancerInfoDTOResponse> getAllFreelancerInfo();
}
