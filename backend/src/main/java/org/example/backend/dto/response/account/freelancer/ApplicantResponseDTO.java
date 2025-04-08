package org.example.backend.dto.response.account.freelancer;

import com.google.type.DateTime;
import lombok.*;
import org.example.backend.enums.StatusFreelancerJob;

import java.time.LocalDateTime;
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
    private LocalDateTime appliedDate;
    private StatusFreelancerJob status;
    private double rating;
    private Long freelancerId;
    private Long jobId;
    private String jobTitle;
    private Long appointmentId;
    private long cvId;
    private String cvURL;
    private Double clientReviewRating;
    private String clientReviewNote;
}
