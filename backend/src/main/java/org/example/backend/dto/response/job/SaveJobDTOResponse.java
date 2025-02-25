package org.example.backend.dto.response.job;

import com.google.type.DateTime;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SaveJobDTOResponse {
    private Long id;
    private String title;
    private String companyName;
    private String jobType;
    private BigDecimal hourWork;
    private BigDecimal fromPrice;
    private BigDecimal toPrice;
    private DateTime appliedDate;
    private String description;
    private List<String> skillNames;
}
