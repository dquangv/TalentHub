package org.example.backend.service.intf.account.freelancer;

import org.example.backend.dto.response.account.freelancer.FreelancerInfoResponse;
import org.example.backend.service.BaseService;

import java.util.List;

public interface FreelancerInfoService {
    List<FreelancerInfoResponse> getAllFreelancerInfo();
}
