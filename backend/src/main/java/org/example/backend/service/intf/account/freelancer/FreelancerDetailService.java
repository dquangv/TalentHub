package org.example.backend.service.intf.account.freelancer;

import org.example.backend.dto.response.account.freelancer.FreelancerDetailDTOResponse;

public interface FreelancerDetailService {
    FreelancerDetailDTOResponse getFreelancerDetail(Long freelancerId);
}
