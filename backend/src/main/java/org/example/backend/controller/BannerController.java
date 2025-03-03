package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.BannerDTORequest;
import org.example.backend.dto.response.BannerDTOResponse;
import org.example.backend.service.intf.BannerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/banners")
@RequiredArgsConstructor
public class BannerController {

    private final BannerService bannerService;

    @PostMapping
    public ResponseObject<BannerDTOResponse> createBanner(@RequestBody BannerDTORequest bannerDTORequest) {
        BannerDTOResponse createdBanner = bannerService.create(bannerDTORequest);
        return ResponseObject.<BannerDTOResponse>builder()
                .message("Banner created successfully")
                .status(HttpStatus.CREATED.value())
                .data(createdBanner)
                .build();
    }

    @GetMapping("/{bannerId}")
    public ResponseObject<BannerDTOResponse> getBannerById(@PathVariable Long bannerId) {
        return bannerService.getById(bannerId)
                .map(bannerResponse -> ResponseObject.<BannerDTOResponse>builder()
                        .message("Banner retrieved successfully")
                        .status(HttpStatus.OK.value())
                        .data(bannerResponse)
                        .build())
                .orElseGet(() -> ResponseObject.<BannerDTOResponse>builder()
                        .message("Banner not found with id: " + bannerId)
                        .status(HttpStatus.NOT_FOUND.value())
                        .data(null)
                        .build());
    }

    @GetMapping
    public ResponseObject<List<BannerDTOResponse>> getAllBanners() {
        List<BannerDTOResponse> banners = bannerService.getAll();
        return ResponseObject.<List<BannerDTOResponse>>builder()
                .message("All banners retrieved successfully")
                .status(HttpStatus.OK.value())
                .data(banners)
                .build();
    }

    @DeleteMapping("/{bannerId}")
    public ResponseObject<Void> deleteBanner(@PathVariable Long bannerId) {
        boolean isDeleted = bannerService.deleteById(bannerId);
        if (isDeleted) {
            return ResponseObject.<Void>builder()
                    .message("Banner deleted successfully")
                    .status(HttpStatus.NO_CONTENT.value())
                    .data(null)
                    .build();
        } else {
            return ResponseObject.<Void>builder()
                    .message("Banner not found with id: " + bannerId)
                    .status(HttpStatus.NOT_FOUND.value())
                    .data(null)
                    .build();
        }
    }
}
