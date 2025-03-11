package org.example.backend.controller.image;
import org.example.backend.service.impl.image.CloudinaryImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private CloudinaryImageServiceImpl cloudinaryImageService;

    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> uploadImage(@RequestParam("file") MultipartFile file) {
        String url = cloudinaryImageService.uploadImage(file);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Upload successful");
        response.put("url", url);
        response.put("status", HttpStatus.OK.value());

        return ResponseEntity.ok(response);
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

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteImage(@RequestParam("url") String url) {
        cloudinaryImageService.deleteImage(url);
        return ResponseEntity.ok("Image deleted successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<String> getImageUrl(@RequestParam("url") String url) {
        String imageUrl = cloudinaryImageService.getImageUrl(url);
        return ResponseEntity.ok(imageUrl);
    }



}