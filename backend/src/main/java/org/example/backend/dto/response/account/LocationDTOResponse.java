package org.example.backend.dto.response.account;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTOResponse {
    private Double lat;
    private Double lng;
}
