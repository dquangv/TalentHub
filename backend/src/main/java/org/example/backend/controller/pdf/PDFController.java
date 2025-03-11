package org.example.backend.controller.pdf;

import org.example.backend.entity.child.account.freelancer.CV;
import org.example.backend.service.intf.CloudinaryPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pdf")
public class PDFController {

    private final CloudinaryPdfService pdfService;


    public PDFController(CloudinaryPdfService pdfService) {
        this.pdfService = pdfService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> uploadPdf(@RequestParam("file") MultipartFile file, @RequestParam("freelancerId") Long freelancerId) {
        String publicId = pdfService.uploadPdf(file, freelancerId);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Upload successful");
        response.put("url", publicId);
        response.put("status", HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }


}