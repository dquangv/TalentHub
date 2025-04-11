package org.example.backend.service.intf;

import org.example.backend.dto.request.ReportedJobDTORequest;
import org.example.backend.dto.response.ReportedJobDTOResponse;
import org.example.backend.service.BaseService;

import java.util.List;

public interface ReportedJobService extends BaseService<ReportedJobDTORequest, ReportedJobDTOResponse, Long> {
    ReportedJobDTOResponse update(Long id, ReportedJobDTORequest request);

    List<ReportedJobDTOResponse> getByJobId(Long jobId);

    List<ReportedJobDTOResponse> getByFreelancerId(Long freelancerId);
}
