package org.example.backend.service.impl.account;

import org.example.backend.dto.request.account.AccountDTORequest;
import org.example.backend.entity.child.account.Account;
import org.example.backend.repository.AccountRepository;
import org.example.backend.service.intf.account.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {


    @Override
    public AccountDTORequest create(AccountDTORequest accountDTORequest) {
        return null;
    }

    @Override
    public Optional<AccountDTORequest> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<AccountDTORequest> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
