package org.example.backend.service.impl.payment;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.payment.EWalletAccountRequest;
import org.example.backend.entity.child.payment.EWalletAccount;
import org.example.backend.service.intf.payment.EWalletAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EWalletAccountServiceImpl implements EWalletAccountService {

    @Override
    public EWalletAccountRequest create(EWalletAccountRequest eWalletAccountRequest) {
        return null;
    }

    @Override
    public Optional<EWalletAccountRequest> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<EWalletAccountRequest> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
