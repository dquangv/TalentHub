package org.example.backend.controller.account.admin;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.response.account.admin.RevenueDTOResponse;
import org.example.backend.service.intf.account.admin.RevenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/revenues")
@RequiredArgsConstructor
public class RevenueController {
    private final RevenueService revenueService;

    @GetMapping("/month/{year}")
    public ResponseEntity<ResponseObject<List<RevenueDTOResponse>>> getRevenueByMonth(@PathVariable int year) {
        List<RevenueDTOResponse> revenues = revenueService.getRevenueByMonth(year);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseObject.<List<RevenueDTOResponse>>builder()
                .message("Get revenue by month for year " + year + " successfully")
                .status(HttpStatus.OK.value())
                .data(revenues)
                .build());
    }

    @GetMapping("/quarter/{year}")
    public ResponseEntity<ResponseObject<List<RevenueDTOResponse>>> getRevenueByQuarter(@PathVariable int year) {
        List<RevenueDTOResponse> revenues = revenueService.getRevenueByQuater(year);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseObject.<List<RevenueDTOResponse>>builder()
                .message("Get revenue by quarter for year " + year + " successfully")
                .status(HttpStatus.OK.value())
                .data(revenues)
                .build());
    }

    @GetMapping("/year")
    public ResponseEntity<ResponseObject<List<RevenueDTOResponse>>> getRevenueByYear() {
        List<RevenueDTOResponse> revenues = revenueService.getRevenueByYear();

        return ResponseEntity.status(HttpStatus.OK).body(ResponseObject.<List<RevenueDTOResponse>>builder()
                .message("Get revenue by year successfully")
                .status(HttpStatus.OK.value())
                .data(revenues)
                .build());
    }

    @GetMapping("/banner/month/{year}")
    public ResponseEntity<ResponseObject<List<RevenueDTOResponse>>> getRevenueBannerByMonth(@PathVariable int year) {
        List<RevenueDTOResponse> revenues = revenueService.getRevenueBannerByMonth(year);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseObject.<List<RevenueDTOResponse>>builder()
                .message("Get banner revenue by month for year " + year + " successfully")
                .status(HttpStatus.OK.value())
                .data(revenues)
                .build());
    }

    @GetMapping("/banner/quarter/{year}")
    public ResponseEntity<ResponseObject<List<RevenueDTOResponse>>> getRevenueBannerByQuater(@PathVariable int year) {
        List<RevenueDTOResponse> revenues = revenueService.getRevenueBannerByQuater(year);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseObject.<List<RevenueDTOResponse>>builder()
                .message("Get banner revenue by quarter for year " + year + " successfully")
                .status(HttpStatus.OK.value())
                .data(revenues)
                .build());
    }

    @GetMapping("/banner/year")
    public ResponseEntity<ResponseObject<List<RevenueDTOResponse>>> getRevenueBannerByYear() {
        List<RevenueDTOResponse> revenues = revenueService.getRevenueBannerByYear();

        return ResponseEntity.status(HttpStatus.OK).body(ResponseObject.<List<RevenueDTOResponse>>builder()
                .message("Get revenue by year successfully")
                .status(HttpStatus.OK.value())
                .data(revenues)
                .build());
    }
}
