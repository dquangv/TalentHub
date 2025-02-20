package org.example.backend.dto.response.account.freelancer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.entity.child.account.freelancer.Degree;
import org.example.backend.entity.child.account.freelancer.Major;
import org.example.backend.entity.child.account.freelancer.School;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationDTOResponse {

    private Long id;
    private Date startDate;
    private Date endDate;
    private String description;
    private School school;
    private Degree degree;
    private Major major;
    private Freelancer freelancer;
}
