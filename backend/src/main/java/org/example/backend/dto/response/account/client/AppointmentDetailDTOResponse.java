package org.example.backend.dto.response.account.client;

import com.google.type.DateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDetailDTOResponse {
    private long id;
    private String name;
    private String mail;
    private String phone;
    private DateTime startTime;
    private Long duration;
    private String topic;
    private String description;
    private String link;
}
