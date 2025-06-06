package org.example.backend.dto.request.account.client;

import com.google.type.DateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDetailDTORequest {
    private LocalDateTime startTime;
    private Long duration;
    private String topic;
    private String description;
    private String link;
    private Long clientId;
    private Long freelancerJobId;
}
