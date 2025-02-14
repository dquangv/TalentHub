package org.example.backend.dto.response.account.freelancer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FreelancerInfoResponse {
    private Long id;
    private String name;
    private String title;
    private String avatar;
    private Double rating;
    private String location;
    private List<String> skills;
    private String hourlyRate;
}
