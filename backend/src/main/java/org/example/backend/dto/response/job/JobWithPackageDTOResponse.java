package org.example.backend.dto.response.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.enums.TypePackage;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobWithPackageDTOResponse {
    private Long id;
    private String title;
    private String companyName;
    private String categoryName;
    private BigDecimal hourWork;
    private BigDecimal fromPrice;
    private BigDecimal toPrice;
    private String description;
    private List<String> skillName;
    private boolean seen;
    private TypePackage typePackage;
    private Date createdAt;
    private String createdTimeFormatted;
}