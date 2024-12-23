package org.example.backend.service.impl.payment;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.payment.BankAccountRequest;
import org.example.backend.entity.child.payment.BankAccount;
import org.example.backend.service.intf.payment.BankAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    @Override
    public BankAccountRequest create(BankAccountRequest bankAccountRequest) {
        return null;
    }

    @Override
    public Optional<BankAccountRequest> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<BankAccountRequest> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
