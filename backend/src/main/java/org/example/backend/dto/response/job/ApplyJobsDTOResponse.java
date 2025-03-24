package org.example.backend.dto.response.job;

import com.google.type.DateTime;
import lombok.Getter;
import lombok.Setter;
import org.example.backend.entity.child.job.JobSkill;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ApplyJobsDTOResponse {
    private Long id;
    private String jobTitle;
    private String companyName;
    private String jobType;
    private BigDecimal hourWork;
    private BigDecimal fromPrice;
    private BigDecimal toPrice;
    private String status;
    private Date applyDate;
    private String description;
    private List<String> SkillNames;
    private Long freelancerJobId;
}
