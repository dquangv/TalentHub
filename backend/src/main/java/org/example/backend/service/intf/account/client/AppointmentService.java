package org.example.backend.service.intf.account.client;

import org.example.backend.dto.request.account.client.AppointmentDetailDTORequest;
import org.example.backend.dto.response.account.client.AppointmentDetailDTOResponse;
import org.example.backend.service.BaseService;

public interface AppointmentService extends BaseService<AppointmentDetailDTORequest, AppointmentDetailDTOResponse, Long> {
    AppointmentDetailDTOResponse getAppointmentDetail(Long clientId, Long jobId, Long freelancerId);
}
