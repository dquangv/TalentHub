package org.example.backend.service.intf.job;

import org.example.backend.dto.request.job.ViewJobDTORequest;
import org.example.backend.dto.response.job.ViewJobDTOResponse;

public interface ViewJobService {
    ViewJobDTOResponse viewJob(ViewJobDTORequest viewJobDTORequest);
}
