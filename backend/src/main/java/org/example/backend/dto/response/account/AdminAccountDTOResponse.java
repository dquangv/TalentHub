package org.example.backend.dto.response.account;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.backend.enums.StatusAccount;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AdminAccountDTOResponse {
    private Long id;
    private String email;
    private String role;
    private StatusAccount status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
