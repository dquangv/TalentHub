package org.example.backend.service.intf;


import org.example.backend.entity.child.account.freelancer.CV;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CloudinaryPdfService {
    String uploadPdf(MultipartFile file, Long freelancerId);

    List<String> uploadMultiplePdfs(MultipartFile[] files);

    void deletePdf(String secureUrl);

    void deletePdfById(Long cvId);

    String getPdfUrl(String secureUrl);

    byte[] downloadPdf(String publicId);

    List<CV> getCVsByFreelancerId(Long freelancerId);
}