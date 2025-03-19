package org.example.backend.service.intf.account.freelancer;

import org.example.backend.dto.request.account.freelancer.DegreeDTORequest;
import org.example.backend.dto.response.account.freelancer.DegreeDTOResponse;
import org.example.backend.service.BaseService;

public interface DegreeService extends BaseService<DegreeDTORequest, DegreeDTOResponse, Long> {
    public DegreeDTOResponse update(Long id, DegreeDTORequest degreeDTORequest);
}
