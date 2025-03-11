package org.example.backend.dto.response.account;

import lombok.*;
import org.example.backend.enums.RoleUser;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationDtoResponse {
    private Long userId;
    private RoleUser role;
    private Long freelancerId;
    private Long clientId;
    private String accessToken;
    private double lat;
    private double lng;
    private String email;
//    private String refreshToken;
}
