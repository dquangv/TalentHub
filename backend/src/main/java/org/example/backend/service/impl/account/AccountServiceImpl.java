package org.example.backend.service.impl.account;

import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.AccountDTORequest;
import org.example.backend.dto.response.AccountGoogleDTOResponse;
import org.example.backend.dto.response.account.AccountDTOResponse;
import org.example.backend.dto.response.account.AuthenticationDtoResponse;
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
import org.example.backend.service.intf.account.AuthenticationService;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends SimpleUrlAuthenticationSuccessHandler implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final UserRepository userRepository;
    private final FreelancerRepository freelancerRepository;
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final AuthenticationServiceImpl authenticationServiceImpl;

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
    public AccountDTOResponse handleOAuth2Register(OAuth2User oauthUser) {
        String email = oauthUser.getAttribute("email");
        String firstName = oauthUser.getAttribute("given_name");
        String lastName = oauthUser.getAttribute("family_name");
        String pictureUrl = oauthUser.getAttribute("picture");

        Account newAccount = new Account();
        newAccount.setEmail(email);
//        newAccount.setRole(RoleUser.FREELANCER);
        newAccount.setStatus(true);
        accountRepository.save(newAccount);

        User user = new User();
        user.setAccount(newAccount);
        user.setImage(pictureUrl);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userRepository.save(user);

        emailService.sendEmail(email, EmailType.REGISTER_SUCCESS, "Account is registered");
        return accountMapper.toResponseDto(newAccount);
    }

    @Transactional
    public AuthenticationDtoResponse handleOAuth2Login(OAuth2User oauthUser) throws JOSEException {
        String email = oauthUser.getAttribute("email");

        Account account = accountRepository.getByEmail(email).get();
        User user = userRepository.findById(account.getId()).get();
        Long freelancerId = null;
        Long clientId = null;

        if (account.getRole().equals(RoleUser.FREELANCER)) {
            Freelancer freelancer = freelancerRepository.findByUserId(user.getId())
                    .orElseThrow(() -> new IllegalIdentifierException("Không tìm thấy freelancer với id: " + user.getId()));

            freelancerId = freelancer.getId();
        } else {
            Client client = clientRepository.findByUserId(user.getId())
                    .orElseThrow(() -> new IllegalIdentifierException("Không tìm thấy client với id: " + user.getId()));

            clientId = client.getId();
        }

        return AuthenticationDtoResponse.builder()
                .accessToken(authenticationServiceImpl.generateAccessToken(account))
                .userId(user.getId())
                .freelancerId(freelancerId)
                .clientId(clientId)
                .role(account.getRole())
                .lat(account.getLat())
                .lng(account.getLng())
                .build();
    }

    @Override
    public AuthenticationDtoResponse updateAccountRole(String email, RoleUser role, double lat, double lng) throws JOSEException {
        AuthenticationDtoResponse authenticationDtoResponse = new AuthenticationDtoResponse();
        Optional<Account> account = accountRepository.findByEmail(email);
        User user = userRepository.findByAccount_Id(account.get().getId());
        account.get().setRole(role);
        account.get().setLat(lat);
        account.get().setLng(lng);
        accountRepository.save(account.get());

        try {
            switch (role) {
                case FREELANCER -> {
                    Freelancer freelancer = new Freelancer();
                    freelancer.setUser(user);
                    freelancerRepository.save(freelancer);
                    authenticationDtoResponse.setFreelancerId(freelancer.getId());
                }
                case CLIENT -> {
                    Client client = new Client();
                    client.setUser(user);
                    clientRepository.save(client);
                    authenticationDtoResponse.setClientId(client.getId());
                }
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid role: " + account.get().getRole());
        }

        return AuthenticationDtoResponse.builder()
                .accessToken(authenticationServiceImpl.generateAccessToken(account.get()))
                .userId(user.getId())
                .role(account.get().getRole())
                .lat(lat)
                .lng(lng)
                .build();
    }
}
