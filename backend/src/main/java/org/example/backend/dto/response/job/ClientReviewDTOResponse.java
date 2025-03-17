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
    private long id;
    private Float rating;
    private String note;
}
