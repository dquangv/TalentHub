package org.example.backend.controller.payment;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.payment.PaymentDTORequest;
import org.example.backend.dto.response.payment.PaymentDTOResponse;
import org.example.backend.service.intf.payment.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseObject<PaymentDTOResponse> createPayment(@Valid @RequestBody PaymentDTORequest paymentDTORequest) {
        PaymentDTOResponse paymentDTOResponse = paymentService.create(paymentDTORequest);
        return ResponseObject.<PaymentDTOResponse>builder()
                .message("Payment created successfully")
                .status(HttpStatus.CREATED.value())
                .data(paymentDTOResponse)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseObject<PaymentDTOResponse> getPaymentById(@PathVariable Long id) {
        return paymentService.getById(id)
                .map(payment -> ResponseObject.<PaymentDTOResponse>builder()
                        .message("Payment retrieved successfully")
                        .status(HttpStatus.OK.value())
                        .data(payment)
                        .build())
                .orElse(ResponseObject.<PaymentDTOResponse>builder()
                        .message("Payment not found")
                        .status(HttpStatus.NOT_FOUND.value())
                        .build());
    }

    @GetMapping
    public ResponseObject<List<PaymentDTOResponse>> getAllPayments() {
        List<PaymentDTOResponse> payments = paymentService.getAll();
        return ResponseObject.<List<PaymentDTOResponse>>builder()
                .message("All payments retrieved successfully")
                .status(HttpStatus.OK.value())
                .data(payments)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseObject<Void> deletePayment(@PathVariable Long id) {
        boolean isDeleted = paymentService.deleteById(id);
        if (isDeleted) {
            return ResponseObject.<Void>builder()
                    .message("Payment deleted successfully")
                    .status(HttpStatus.NO_CONTENT.value())
                    .build();
        }
        return ResponseObject.<Void>builder()
                .message("Payment not found")
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }
}*/
