package org.example.backend.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BannerDTOResponse {
    private Long id;
    private String title;
    private String image;
    private String status;
    private String vendor;
    private String createdAt;
    private String updatedAt;
}
