package org.example.backend.controller.account.client;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.account.client.CompanyDTORequest;
import org.example.backend.dto.response.account.client.CompanyDTOResponse;
import org.example.backend.service.intf.account.client.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseObject<CompanyDTOResponse> createCompany(@Valid @RequestBody CompanyDTORequest companyDTORequest) {
        CompanyDTOResponse companyDTOResponse = companyService.create(companyDTORequest);
        return ResponseObject.<CompanyDTOResponse>builder()
                .message("Company created successfully")
                .status(HttpStatus.CREATED.value())
                .data(companyDTOResponse)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseObject<CompanyDTOResponse> getCompanyById(@PathVariable Long id) {
        return companyService.getById(id)
                .map(company -> ResponseObject.<CompanyDTOResponse>builder()
                        .message("Company retrieved successfully")
                        .status(HttpStatus.OK.value())
                        .data(company)
                        .build())
                .orElse(ResponseObject.<CompanyDTOResponse>builder()
                        .message("Company not found")
                        .status(HttpStatus.NOT_FOUND.value())
                        .build());
    }

    @GetMapping
    public ResponseObject<List<CompanyDTOResponse>> getAllCompanies() {
        List<CompanyDTOResponse> companies = companyService.getAll();
        return ResponseObject.<List<CompanyDTOResponse>>builder()
                .message("All companies retrieved successfully")
                .status(HttpStatus.OK.value())
                .data(companies)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseObject<Void> deleteCompany(@PathVariable Long id) {
        boolean isDeleted = companyService.deleteById(id);
        if (isDeleted) {
            return ResponseObject.<Void>builder()
                    .message("Company deleted successfully")
                    .status(HttpStatus.NO_CONTENT.value())
                    .build();
        }
        return ResponseObject.<Void>builder()
                .message("Company not found")
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }
}
