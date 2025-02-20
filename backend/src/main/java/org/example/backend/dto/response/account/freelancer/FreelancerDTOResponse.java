package org.example.backend.dto.response.account.freelancer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class FreelancerDTOResponse {

    private Long id;
//    private String image;
    private BigDecimal hourlyRate;
    private String description;
    private String categoryName;
    private Long userId;
}

