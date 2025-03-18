package org.example.backend.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
public class BannerDTORequest {
    private String title;
    private MultipartFile image;
    private String status;
    private String vendor;
    private LocalDate startTime;
    private LocalDate endTime;
}
