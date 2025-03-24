package org.example.backend.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BannerDTOResponse {
    private Long id;
    private String title;
    private String image;
    private boolean status;
    private String vendor;
//    private String createdAt;
//    private String updatedAt;
    private String startTime;
    private String endTime;
}
