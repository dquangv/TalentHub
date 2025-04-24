package org.example.backend.dto.response.account.freelancer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.enums.StatusAccount;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FreelancerInfoDTOResponse {
    private Long id;
    private String name;
    private String title;
    private String avatar;
    private Float rating;
    private String province;
    private String country;
    private List<String> skills;
    private String hourlyRate;
    private StatusAccount status;
}
