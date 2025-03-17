package org.example.backend.dto.response.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backend.enums.RoleUser;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String province;
    private String country;
    private String title;
    private String introduction;
    private String image;
    private RoleUser role;
}