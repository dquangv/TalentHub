package org.example.backend.service.impl;

import org.example.backend.entity.child.account.Account;
import org.example.backend.repository.AccountRepository;
import org.example.backend.service.intf.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {


    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account create(  Account account) {
        try {
            return accountRepository.save(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Failed to create account");
    }

    @Override
    public Account delete(Account account) {
        return null;
    }

    @Override
    public Account get(Account account) {
        return null;
    }

    @Override
    public List<Account> getAll() {
        return List.of();
    }
}
