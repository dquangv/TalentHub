package org.example.backend.dto.request;

import lombok.Getter;
import lombok.Setter;

import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class BannerDTORequest {
    private String title;
    private MultipartFile image;
    private String status;
    private String vendor;
}
