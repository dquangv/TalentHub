package org.example.backend.dto.response.account.freelancer;

import com.google.type.DateTime;
import lombok.*;
import org.example.backend.enums.StatusFreelancerJob;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ApplicantResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String image;
    private String position;
    private DateTime appliedDate;
    private StatusFreelancerJob status;
    private double rating;


}
