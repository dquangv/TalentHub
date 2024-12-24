package org.example.backend.service.impl.account;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.AccountDTORequest;
import org.example.backend.dto.response.account.AccountDTOResponse;
import org.example.backend.entity.child.account.Account;
import org.example.backend.exception.NotFoundException;
import org.example.backend.mapper.Account.AccountMapper;
import org.example.backend.repository.AccountRepository;
import org.example.backend.service.intf.account.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountDTOResponse create(AccountDTORequest accountRequestDTO) {
        Account account = accountMapper.toEntity(accountRequestDTO);
        Account savedAccount = accountRepository.save(account);

        return accountMapper.toResponseDto(savedAccount);
    }


    @Override
    public Optional<AccountDTOResponse> getById(Long id) {
        return Optional.ofNullable(accountRepository.findById(id)
                .map(accountMapper::toResponseDto)
                .orElseThrow(() -> new NotFoundException("Account with ID " + id + " not found")));
    }

    @Override
    public List<AccountDTOResponse> getAll() {
        List<Account> accounts = accountRepository.findAll();

        if (accounts.isEmpty()) {
            throw new NotFoundException("No accounts found");
        }

        return accounts.stream()
                .map(accountMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }
}
