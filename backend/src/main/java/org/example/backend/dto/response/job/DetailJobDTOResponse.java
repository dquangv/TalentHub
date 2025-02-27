package org.example.backend.dto.response.job;

import lombok.Getter;
import lombok.Setter;
import org.example.backend.entity.child.account.client.Client;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class DetailJobDTOResponse {
    private Long id;
    private String title;
    private String companyName;
    private Long clientId;
    private String firstName;
    private String lastName;
    private String type;
    private BigDecimal hourWork;
    private BigDecimal fromPrice;
    private BigDecimal toPrice;
    private String description;
    private List<String> skillNames;
}
