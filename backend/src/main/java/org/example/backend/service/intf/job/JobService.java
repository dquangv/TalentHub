package org.example.backend.service.intf.job;

import org.example.backend.dto.request.job.JobDTORequest;
import org.example.backend.dto.response.job.JobDTOResponse;
import org.example.backend.service.BaseService;

public interface JobService extends BaseService<JobDTORequest, JobDTOResponse, Long> {
}
