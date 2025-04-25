package org.example.backend.service.intf.account.client;

import org.example.backend.dto.request.account.client.AppointmentDetailDTORequest;
import org.example.backend.dto.response.account.client.AppointmentDetailDTOResponse;
import org.example.backend.service.BaseService;

import java.util.List;

public interface AppointmentService extends BaseService<AppointmentDetailDTORequest, AppointmentDetailDTOResponse, Long> {
    List<AppointmentDetailDTOResponse> getAllAppointmentsByClientId(Long clientId);

    List<AppointmentDetailDTOResponse> getAllAppointmentsByFreelancerId(Long freelancerId);

    AppointmentDetailDTOResponse update(Long id, AppointmentDetailDTORequest request);

    String markAppointmentAsCompleted(Long id);
}
