package org.example.backend.service.impl.account;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.AccountDTORequest;
import org.example.backend.dto.response.account.AccountDTOResponse;
import org.example.backend.entity.child.account.Account;
import org.example.backend.entity.child.account.User;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.enums.EmailType;
import org.example.backend.enums.RoleUser;
import org.example.backend.exception.NotFoundException;
import org.example.backend.mapper.Account.AccountMapper;
import org.example.backend.repository.AccountRepository;
import org.example.backend.repository.ClientRepository;
import org.example.backend.repository.FreelancerRepository;
import org.example.backend.repository.UserRepository;
import org.example.backend.service.intf.EmailService;
import org.example.backend.service.intf.account.AccountService;
import org.example.backend.utils.GeoUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    private final UserRepository userRepository;

    private final FreelancerRepository freelancerRepository;

    private final ClientRepository clientRepository;

    private final PasswordEncoder passwordEncoder;

    private final EmailService emailService;



    @Transactional
    @Override
    public AccountDTOResponse create(AccountDTORequest accountRequestDTO) {
        if (accountRepository.existsByEmail(accountRequestDTO.getEmail())) {
            throw new IllegalArgumentException("Account with email "
                    + accountRequestDTO.getEmail() + " already exists");
        }
        Account account = accountMapper.toEntity(accountRequestDTO);
        account.setEmail(accountRequestDTO.getEmail());
        account.setPassword(passwordEncoder.encode(accountRequestDTO.getPassword()));
        account.setRole(accountRequestDTO.getRole());
        account.setStatus(accountRequestDTO.getStatus());
        account.setLat(accountRequestDTO.getLat());
        account.setLng(accountRequestDTO.getLng());

        Account savedAccount = accountRepository.save(account);

        User user = new User();

//        user.setFirstName(accountRequestDTO.getFirstName());
//        user.setLastName(accountRequestDTO.getLastName());
//        user.setPhoneNumber(accountRequestDTO.getPhoneNumber());
//        user.setAddress(accountRequestDTO.getAddress());
//        user.setTitle(accountRequestDTO.getTitle());
//        user.setIntroduction(accountRequestDTO.getIntroduction());

        user.setAccount(savedAccount);

//        account.setUser(user);

        accountRepository.save(account);
        userRepository.save(user);

        try {
            RoleUser role = RoleUser.valueOf(accountRequestDTO.getRole().getValue().toUpperCase());

            switch (role) {
                case FREELANCER -> {
                    Freelancer freelancer = new Freelancer();
                    freelancer.setUser(user);
                    freelancerRepository.save(freelancer);
                }
                case CLIENT -> {
                    Client client = new Client();
                    client.setUser(user);
                    clientRepository.save(client);
                }
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid role: " + accountRequestDTO.getRole());
        }

        emailService.sendEmail(accountRequestDTO.getEmail(), EmailType.REGISTER_SUCCESS, "Account is registered");
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
        return accountMapper.toResponseDtoList(accounts);
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }

    @Transactional
    @Override
    public List<AccountDTOResponse> getNearbyUsers(double lat, double lon, double distanceInMeters) {
        List<Account> accounts = accountRepository.findAll();

        List<AccountDTOResponse> nearbyUsers = accounts.stream()
                .filter(account -> {
                    double distance = GeoUtils.calculateDistance(lat, lon, account.getLat(), account.getLng());
                    return distance <= distanceInMeters;
                })
                .map(accountMapper::toResponseDto)
                .collect(Collectors.toList());

        return nearbyUsers;
    }
}
