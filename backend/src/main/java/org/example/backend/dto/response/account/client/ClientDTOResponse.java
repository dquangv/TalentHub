package org.example.backend.dto.response.account.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTOResponse {

    private Long id;
    private Double fromPrice;
    private Double toPrice;
    private String typePrice;
    private Long userId;
    private int appointmentsCount;
    private int jobsCount;
    private String email;
    private String province;
    private String country;
    private String image;
}
