package org.example.backend.controller.account.client;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.account.client.SoldPackageDTORequest;
import org.example.backend.dto.response.account.client.SoldPackageDTOResponse;
import org.example.backend.entity.child.account.client.SoldPackage;
import org.example.backend.service.intf.account.client.SoldPackageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clients/soldpackages")
public class SoldPackageController {
    private final SoldPackageService soldPackageService;

    @PostMapping
    public ResponseEntity<ResponseObject<SoldPackageDTOResponse>> subcribePackage(@RequestBody SoldPackageDTORequest soldPackage) {
        SoldPackageDTOResponse soldPackageDTOResponse = soldPackageService.create(soldPackage);

        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseObject.<SoldPackageDTOResponse>builder()
                .message("Successfully subcribe a package")
                .status(201)
                .data(soldPackageDTOResponse)
                .build());
    }
}
