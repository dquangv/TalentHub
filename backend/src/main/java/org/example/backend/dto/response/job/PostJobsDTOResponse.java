package org.example.backend.dto.response.job;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostJobsDTOResponse {
    private Long id;
    private String title;
    private String type;
    private Long applicants;
    private LocalDateTime postedDate;
    private String status;
}
