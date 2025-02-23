package org.example.backend.dto.response.account;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.backend.enums.RoleUser;

@Getter
@Setter
@Builder
public class AuthenticationDtoResponse {
   private Long userId;
   private RoleUser role;
private Long freelancerId;
private Long clientId;
   private String accessToken;
//    private String refreshToken;
}
