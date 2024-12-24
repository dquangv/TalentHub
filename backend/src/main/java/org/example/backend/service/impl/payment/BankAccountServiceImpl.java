package org.example.backend.service.impl.payment;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.payment.BankAccountDTORequest;
import org.example.backend.dto.response.payment.BankAccountDTOResponse;
import org.example.backend.service.intf.payment.BankAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    @Override
    public BankAccountDTOResponse create(BankAccountDTORequest bankAccountRequest) {
        return null;
    }

    @Override
    public Optional<BankAccountDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<BankAccountDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
