package org.example.backend.service.impl.image;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CloudinaryImageService {

    private final Cloudinary cloudinary;

    public CloudinaryImageService(
            @Value("${cloudinary.cloud-name}") String cloudName,
            @Value("${cloudinary.api-key}") String apiKey,
            @Value("${cloudinary.api-secret}") String apiSecret) {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret));
    }

    public String uploadImage(MultipartFile file) {
        try {
            String publicId = "talenthub_images/" + System.currentTimeMillis() + "-" + file.getOriginalFilename();
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                    "resource_type", "image",
                    "public_id", publicId,
                    "folder", "talenthub_images"
            ));
            return (String) uploadResult.get("secure_url");
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image: " + e.getMessage());
        }
    }


    public List<String> uploadMultipleImages(MultipartFile[] files) {
        List<String> imageUrls = new ArrayList<>();
        for (MultipartFile file : files) {
            try {
                String publicId = "talenthub_images/" + System.currentTimeMillis() + "-" + file.getOriginalFilename();
                Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                        "resource_type", "image",
                        "public_id", publicId,
                        "folder", "talenthub_images"
                ));
                imageUrls.add((String) uploadResult.get("secure_url"));
            } catch (IOException e) {
                throw new RuntimeException("Failed to upload multiple images: " + e.getMessage());
            }
        }
        return imageUrls;
    }
    private String extractPublicIdFromUrl(String secureUrl) {
        String[] parts = secureUrl.split("/upload/");
        if (parts.length < 2) {
            throw new IllegalArgumentException("Invalid secure_url format");
        }
        String afterUpload = parts[1];
        String publicId = afterUpload.replaceAll("^v[0-9]+/", "").split("\\.")[0];
        return publicId;
    }

    public String updateImage(String oldSecureUrl, MultipartFile newFile) {
        try {
            String oldPublicId = extractPublicIdFromUrl(oldSecureUrl);
            cloudinary.uploader().destroy(oldPublicId, ObjectUtils.emptyMap());
            String newPublicId = "talenthub_images/" + System.currentTimeMillis() + "-" + newFile.getOriginalFilename();
            Map uploadResult = cloudinary.uploader().upload(newFile.getBytes(), ObjectUtils.asMap(
                    "resource_type", "image",
                    "public_id", newPublicId,
                    "folder", "talenthub_images"
            ));
            return (String) uploadResult.get("secure_url");
        } catch (IOException e) {
            throw new RuntimeException("Failed to update image: " + e.getMessage());
        }
    }

    public void deleteImage(String secureUrl) {
        try {
            String publicId = extractPublicIdFromUrl(secureUrl);
            cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete image: " + e.getMessage());
        }
    }

    public String getImageUrl(String secureUrl) {
        try {
            String publicId = extractPublicIdFromUrl(secureUrl);
            Map resource = cloudinary.api().resource(publicId, ObjectUtils.emptyMap());
            return (String) resource.get("secure_url");
        } catch (Exception e) {
            throw new RuntimeException("Failed to get image: " + e.getMessage());
        }
    }

}