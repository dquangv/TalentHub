package org.example.backend.service.intf.payment;

import org.example.backend.dto.PaymentResDTO;
import org.example.backend.dto.request.payment.PaymentDTORequest;
import org.example.backend.dto.response.ResultPaymentResponseDTO;
import org.example.backend.dto.response.payment.PaymentDTOResponse;
import org.example.backend.dto.response.payment.WithdrawResponseDTO;
import org.example.backend.service.BaseService;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

public interface PaymentService extends BaseService<PaymentDTORequest, PaymentDTOResponse, Long> {
    PaymentResDTO createVnPayPayment(BigDecimal amount) throws UnsupportedEncodingException;
    ResultPaymentResponseDTO handleVnPayCallback(String vnp_ResponseCode, BigDecimal vnpAmount, Long userId);
    WithdrawResponseDTO handleVnPayWithCallback(BigDecimal vnpAmount, Long userId);
}
