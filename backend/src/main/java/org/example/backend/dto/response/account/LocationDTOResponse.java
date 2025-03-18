package org.example.backend.dto.response.account;

import lombok.*;
import org.example.backend.enums.RoleUser;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTOResponse {
    private Double lat;
    private Double lng;
    private RoleUser role;
}
