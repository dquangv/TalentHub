package org.example.backend.service.impl.payment;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.payment.PaymentDTORequest;
import org.example.backend.entity.child.payment.Payment;
import org.example.backend.service.intf.payment.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    @Override
    public PaymentDTORequest create(PaymentDTORequest paymentDTORequest) {
        return null;
    }

    @Override
    public Optional<PaymentDTORequest> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<PaymentDTORequest> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
