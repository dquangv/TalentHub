package org.example.backend.service.intf.image;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CloudinaryImageService {
    public String uploadImage(MultipartFile file);

    public List<String> uploadMultipleImages(MultipartFile[] files);

    public String updateImage(String oldSecureUrl, MultipartFile newFile);

    public void deleteImage(String secureUrl);
}
