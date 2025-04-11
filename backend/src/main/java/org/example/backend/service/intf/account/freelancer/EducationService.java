package org.example.backend.service.intf.account.freelancer;

import org.example.backend.dto.request.account.freelancer.EducationDTORequest;
import org.example.backend.dto.response.account.freelancer.EducationDTOResponse;
import org.example.backend.service.BaseService;

import java.util.List;

public interface EducationService extends BaseService<EducationDTORequest, EducationDTOResponse, Long> {
    EducationDTOResponse update(Long id, EducationDTORequest educationDTORequest);

    List<EducationDTOResponse> getByFreelancerId(Long freelancerId);
}
