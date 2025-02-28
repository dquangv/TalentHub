package org.example.backend.controller.image;
import org.example.backend.service.impl.image.CloudinaryImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private CloudinaryImageServiceImpl cloudinaryImageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        String url = cloudinaryImageService.uploadImage(file);
        return ResponseEntity.ok(url);
    }

    @PostMapping("/upload/multiple")
    public ResponseEntity<List<String>> uploadMultipleImages(@RequestParam("files") MultipartFile[] files) {
        List<String> urls = cloudinaryImageService.uploadMultipleImages(files);
        return ResponseEntity.ok(urls);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateImage(@RequestParam("oldUrl") String oldUrl,
                                              @RequestParam("newFile") MultipartFile newFile) {
        String newUrl = cloudinaryImageService.updateImage(oldUrl, newFile);
        return ResponseEntity.ok(newUrl);
    }




}