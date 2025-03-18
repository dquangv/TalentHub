package org.example.backend.service.intf.account.freelancer;

import org.example.backend.dto.request.account.freelancer.SchoolDTORequest;
import org.example.backend.dto.response.account.freelancer.SchoolDTOResponse;
import org.example.backend.service.BaseService;

public interface SchoolService extends BaseService<SchoolDTORequest, SchoolDTOResponse, Long> {
    public SchoolDTOResponse update(Long id, SchoolDTORequest schoolDTORequest);
}
