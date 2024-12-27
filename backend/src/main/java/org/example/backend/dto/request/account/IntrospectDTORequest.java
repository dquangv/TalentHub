package org.example.backend.dto.request.account;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IntrospectDTORequest {
    private String accessToken;
}
