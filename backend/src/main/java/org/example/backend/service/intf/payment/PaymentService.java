package org.example.backend.service.intf.payment;

import org.example.backend.dto.request.payment.PaymentDTORequest;
import org.example.backend.entity.child.payment.Payment;
import org.example.backend.service.BaseService;

public interface PaymentService extends BaseService<PaymentDTORequest,Long> {
}
