package org.example.backend.controller.account.admin;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.account.admin.VoucherPackageDTORequest;
import org.example.backend.dto.response.account.admin.VoucherPackageDTOResponse;
import org.example.backend.service.intf.account.admin.VoucherPackageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/voucher-packages")
@RequiredArgsConstructor
public class VoucherPackageController {

    private final VoucherPackageService voucherPackageService;

    @PostMapping
    public ResponseObject<VoucherPackageDTOResponse> create(@RequestBody VoucherPackageDTORequest request) {
        VoucherPackageDTOResponse response = voucherPackageService.create(request);
        return ResponseObject.<VoucherPackageDTOResponse>builder()
                .message("Voucher package created successfully")
                .status(201)
                .data(response)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseObject<VoucherPackageDTOResponse> update(@PathVariable Long id, @RequestBody VoucherPackageDTORequest request) {
        VoucherPackageDTOResponse response = voucherPackageService.update(id, request);
        return ResponseObject.<VoucherPackageDTOResponse>builder()
                .message("Voucher package updated successfully")
                .status(200)
                .data(response)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseObject<VoucherPackageDTOResponse> getById(@PathVariable Long id) {
        return voucherPackageService.getById(id)
                .map(response -> ResponseObject.<VoucherPackageDTOResponse>builder()
                        .message("Voucher package fetched successfully")
                        .status(200)
                        .data(response)
                        .build())
                .orElseGet(() -> ResponseObject.<VoucherPackageDTOResponse>builder()
                        .message("Voucher package not found")
                        .status(404)
                        .build());
    }

    @GetMapping
    public ResponseObject<List<VoucherPackageDTOResponse>> getAll() {
        List<VoucherPackageDTOResponse> response = voucherPackageService.getAll();
        return ResponseObject.<List<VoucherPackageDTOResponse>>builder()
                .message("Voucher packages fetched successfully")
                .status(200)
                .data(response)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseObject<Void> delete(@PathVariable Long id) {
        boolean deleted = voucherPackageService.deleteById(id);
        if (deleted) {
            return ResponseObject.<Void>builder()
                    .message("Voucher package deleted successfully")
                    .status(204)
                    .build();
        } else {
            return ResponseObject.<Void>builder()
                    .message("Voucher package not found")
                    .status(404)
                    .build();
        }
    }
}
