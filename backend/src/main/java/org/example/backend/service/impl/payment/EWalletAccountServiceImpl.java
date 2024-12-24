package org.example.backend.service.impl.payment;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.payment.EWalletAccountDTORequest;
import org.example.backend.dto.response.payment.EWalletAccountDTOResponse;
import org.example.backend.service.intf.payment.EWalletAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EWalletAccountServiceImpl implements EWalletAccountService {

    @Override
    public EWalletAccountDTOResponse create(EWalletAccountDTORequest eWalletAccountRequest) {
        return null;
    }

    @Override
    public Optional<EWalletAccountDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<EWalletAccountDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
