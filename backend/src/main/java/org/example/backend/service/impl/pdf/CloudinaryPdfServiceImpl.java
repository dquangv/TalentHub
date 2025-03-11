package org.example.backend.service.impl.pdf;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.example.backend.entity.child.account.freelancer.CV;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.repository.CVRepository;
import org.example.backend.repository.FreelancerRepository;
import org.example.backend.service.intf.CloudinaryPdfService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CloudinaryPdfServiceImpl implements CloudinaryPdfService {

    private final Cloudinary cloudinary;
    private final FreelancerRepository freelancerRepository;
    private final CVRepository cvRepository;

    public CloudinaryPdfServiceImpl(
            @Value("${cloudinary.cloud-name}") String cloudName,
            @Value("${cloudinary.api-key}") String apiKey,
            @Value("${cloudinary.api-secret}") String apiSecret,
            FreelancerRepository freelancerRepository,
            CVRepository cvRepository) {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret));
        this.freelancerRepository = freelancerRepository;
        this.cvRepository = cvRepository;
    }

    @Override
    public String uploadPdf(MultipartFile file, Long freelancerId) {
        try {
            if (!file.getContentType().equals("application/pdf")) {
                throw new IllegalArgumentException("File phải là định dạng PDF");
            }

            String publicId = "talenthub_pdfs/" + System.currentTimeMillis() + "-" + file.getOriginalFilename();
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                    "resource_type", "raw",
                    "public_id", publicId,
                    "folder", "talenthub_pdfs"
            ));
            Freelancer freelancer = freelancerRepository.findById(freelancerId)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Freelancer với ID: " + freelancerId));
            CV cv = new CV();
            cv.setTitle(file.getOriginalFilename());
            cv.setUrl(publicId);
            cv.setFreelancer(freelancer);
            cv.setStatus(true);
            cvRepository.save(cv);
            return (String) uploadResult.get("public_id");
        } catch (IOException e) {
            throw new RuntimeException("Không thể upload PDF: " + e.getMessage());
        }
    }


}