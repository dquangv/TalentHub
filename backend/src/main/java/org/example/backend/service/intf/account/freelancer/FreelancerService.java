package org.example.backend.service.intf.account.freelancer;

import org.example.backend.dto.request.account.freelancer.CreateFreelancerDTORequest;
import org.example.backend.dto.request.account.freelancer.FreelancerDTORequest;
import org.example.backend.dto.request.account.freelancer.UpdateHourlyRateDTORequest;
import org.example.backend.dto.response.account.freelancer.CreateFreelancerDTOResponse;
import org.example.backend.dto.response.account.freelancer.FreelancerAdminDTOResponse;
import org.example.backend.dto.response.account.freelancer.FreelancerDTOResponse;
import org.example.backend.dto.response.account.freelancer.UpdateHourlyRateDTOResponse;
import org.example.backend.service.BaseService;

import java.util.List;

public interface FreelancerService extends BaseService<FreelancerDTORequest, FreelancerDTOResponse, Long> {
    CreateFreelancerDTOResponse createProfile(CreateFreelancerDTORequest request);
    UpdateHourlyRateDTOResponse updateHourlyRate(UpdateHourlyRateDTORequest request);
    FreelancerDTOResponse updateCategory(Long freelancerId, Long categoryId);
    public List<FreelancerAdminDTOResponse> getAllByAdmin();
    List<FreelancerDTOResponse> getFreelancersByCategoryId(Long categoryId);
}

