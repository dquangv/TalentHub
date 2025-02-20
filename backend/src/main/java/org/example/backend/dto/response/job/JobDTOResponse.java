package org.example.backend.dto.response.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.backend.enums.StatusFreelancerJob;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobDTOResponse {
    private Long id;
    private String title;
    private String companyName;
    private BigDecimal hourWork;
    private BigDecimal fromPrice;
    private BigDecimal toPrice;
    private String description;
    private List<String> skillName;

    // Constructor dùng cho JPQL projection
    public JobDTOResponse(Long id, String title, String companyName,
                          BigDecimal hourWork, BigDecimal fromPrice,
                          BigDecimal toPrice, String description, String skillNames) {
        this.id = id;
        this.title = title;
        this.companyName = companyName;
        this.hourWork = hourWork;
        this.fromPrice = fromPrice;
        this.toPrice = toPrice;
        this.description = description;
        // Giả sử các skill được nối với nhau bằng dấu phẩy, bạn có thể tách thành List:
        this.skillName = Arrays.asList(skillNames.split(","));
    }

}
