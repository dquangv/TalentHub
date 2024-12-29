package org.example.backend.dto.response.account;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationDtoResponse {
    private String accessToken;
    private String refreshToken;
}
