package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.PaymentResDTO;
import org.example.backend.dto.response.ResultPaymentResponseDTO;
import org.example.backend.dto.response.payment.WithdrawResponseDTO;
import org.example.backend.service.intf.payment.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/vnpay")
    public ResponseEntity<PaymentResDTO> vnpay(@RequestParam("amount") BigDecimal amount
                                              ) throws UnsupportedEncodingException {
        return ResponseEntity.ok(paymentService.createVnPayPayment(amount));
    }

    @PostMapping("/vnpay-callback")
    public ResponseEntity<ResultPaymentResponseDTO> vnpayCallback(@RequestParam("vnp_ResponseCode") String vnp_ResponseCode,
                                                                  @RequestParam("vnp_Amount") BigDecimal vnpAmount,
                                                                  @RequestParam("userId") Long userId) throws UnsupportedEncodingException {
        return ResponseEntity.ok(paymentService.handleVnPayCallback(vnp_ResponseCode, vnpAmount, userId));
    }

    @PostMapping("/vnpay-with-callback")
    public ResponseEntity<WithdrawResponseDTO> vnpayWithCallback(
                                                                  @RequestParam("vnp_Amount") BigDecimal vnpAmount,
                                                                  @RequestParam("userId") Long userId) throws UnsupportedEncodingException {
        return ResponseEntity.ok(paymentService.handleVnPayWithCallback(vnpAmount, userId));
    }

}