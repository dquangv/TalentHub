package org.example.backend.controller.account;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.account.client.AppointmentDetailDTORequest;
import org.example.backend.dto.response.account.client.AppointmentDetailDTOResponse;
import org.example.backend.service.intf.account.client.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/client")
    public ResponseEntity<ResponseObject<AppointmentDetailDTOResponse>> createAppointment(@RequestBody AppointmentDetailDTORequest request) {
        AppointmentDetailDTOResponse response = appointmentService.create(request);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseObject.<AppointmentDetailDTOResponse>builder()
                .message("Successfully create appointment")
                .status(201)
                .data(response)
                .build());
    }
}
