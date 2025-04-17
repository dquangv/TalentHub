package org.example.backend.dto.response.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientReviewDTOResponse {
    private Long id;
    private Float rating;
    private String note;
    private String reviewerName;
}
