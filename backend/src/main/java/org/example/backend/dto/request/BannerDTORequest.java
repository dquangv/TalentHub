package org.example.backend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BannerDTORequest {
    private String title;
    private String image;
    private String status;
    private String vendor;
}
