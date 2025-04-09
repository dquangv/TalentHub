package org.example.backend.dto.response.account.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDetailDTOResponse {
    private long id;
    private String name;
    private String mail;
    private String phone;
    private LocalDateTime startTime;
    private Long duration;
    private String topic;
    private String description;
    private String link;
    private Long jobId;
    private String jobTitle;
}