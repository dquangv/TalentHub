package org.example.backend.dto.request.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FreelancerReviewDTORequest {
    private Float rating;
    private String note;
}
