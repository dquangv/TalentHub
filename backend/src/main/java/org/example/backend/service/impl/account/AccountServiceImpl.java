package org.example.backend.service.impl.account;

import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.AccountDTORequest;
import org.example.backend.dto.request.account.client.SoldPackageDTORequest;
import org.example.backend.dto.response.account.AccountDTOResponse;
import org.example.backend.dto.response.account.AdminAccountDTOResponse;
import org.example.backend.dto.response.account.AuthenticationDtoResponse;
import org.example.backend.dto.response.account.LocationDTOResponse;
import org.example.backend.entity.child.account.Account;
import org.example.backend.entity.child.account.User;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.entity.child.account.client.SoldPackage;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.entity.child.admin.VoucherPackage;
import org.example.backend.enums.EmailType;
import org.example.backend.enums.RoleUser;
import org.example.backend.enums.StatusAccount;
import org.example.backend.enums.TypePackage;
import org.example.backend.exception.NotFoundException;
import org.example.backend.mapper.Account.AccountMapper;
import org.example.backend.mapper.Account.AdminAccountMapper;
import org.example.backend.mapper.Account.LocationMapper;
import org.example.backend.repository.*;
import org.example.backend.service.intf.EmailService;
import org.example.backend.service.intf.account.AccountService;
import org.example.backend.service.intf.account.AuthenticationService;
import org.example.backend.service.intf.account.client.SoldPackageService;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.example.backend.utils.GeoUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    private final SoldPackageRepository soldPackageRepository;
    private final VoucherPackageRepository voucherPackageRepository;

    @Override
    public boolean changePassword(String email, String currentPassword, String newPassword) {
        Optional<Account> accountOptional = accountRepository.findByEmail(email);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            System.out.println("password: " + account.getPassword());
            System.out.println("currentPassword: " + currentPassword);

            if (passwordEncoder.matches(currentPassword, account.getPassword())) {
                account.setPassword(passwordEncoder.encode(newPassword));
                accountRepository.save(account);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean checkEmail(String email) {
        return accountRepository.existsByEmail(email);
    }
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
        System.out.println("lat " + accountRequestDTO.getLat());
        System.out.println("lng " + accountRequestDTO.getLng());

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

                    VoucherPackage voucherPackage = voucherPackageRepository.findTopByTypePackageOrderByIdDesc(TypePackage.NORMAL);

                    SoldPackage soldPackage = new SoldPackage();
                    soldPackage.setStartDate(LocalDateTime.now());
                    soldPackage.setEndDate(LocalDateTime.now().plusDays(voucherPackage.getDuration()));
                    soldPackage.setNumberPost(voucherPackage.getNumberPost());
                    soldPackage.setNumberPosted(Long.valueOf(0));
                    soldPackage.setVoucherPackage(voucherPackage);
                    soldPackage.setPrice(voucherPackage.getPrice());
                    soldPackage.setVoucherPackage(voucherPackage);
                    soldPackage.setClient(client);
                    soldPackage.setStatus(true);

                    soldPackageRepository.save(soldPackage);
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
    private final AdminAccountMapper adminAccountMapper;
    @Override
    public List<AdminAccountDTOResponse> getAllByAdmin() {
        List<Account> accounts = accountRepository.findAll();


        return accounts.stream().map(adminAccountMapper::toResponseDTO).toList();
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }

    public AccountDTOResponse handleOAuth2Register(OAuth2User oauthUser) {
        System.out.println("oauth2 " + oauthUser.toString());

        String registrationId = ((OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication()).getAuthorizedClientRegistrationId();
        System.out.println("OAuth2 provider: " + registrationId);

        String email = null;
        String firstName = oauthUser.getAttribute("given_name");
        String lastName = oauthUser.getAttribute("family_name");
        String pictureUrl = oauthUser.getAttribute("picture");

        if ("google".equals(registrationId)) {
            email = oauthUser.getAttribute("email");
            System.out.println("Google login, using email: " + email);
        } else if ("facebook".equals(registrationId)) {
            String fullName = oauthUser.getAttribute("name");
            firstName = fullName.split(" ")[0];
            lastName = fullName.split(" ")[1];
            email = oauthUser.getAttribute("id") + "@facebook.com";
            System.out.println("Facebook login, using Facebook ID as email: " + email);
        }

        Account newAccount = new Account();
        newAccount.setEmail(email);
//        newAccount.setStatus(true);
        accountRepository.save(newAccount);

        User user = new User();
        user.setAccount(newAccount);
        user.setImage(pictureUrl);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userRepository.save(user);
//        emailService.sendEmail(email, EmailType.REGISTER_SUCCESS, "Account is registered");

        return accountMapper.toResponseDto(newAccount);
    }


    @Transactional
    public AuthenticationDtoResponse handleOAuth2Login(OAuth2User oauthUser) throws JOSEException {
        String registrationId = ((OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication()).getAuthorizedClientRegistrationId();
        System.out.println("OAuth2 provider: " + registrationId);

        String email = null;

        if ("google".equals(registrationId)) {
            email = oauthUser.getAttribute("email");
        } else if ("facebook".equals(registrationId)) {
            email = oauthUser.getAttribute("id") + "@facebook.com";
        }

        Account account = accountRepository.getByEmail(email).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy account với email này"));
        User user = userRepository.findById(account.getId()).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy user với account này"));

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

                    account.get().setStatus(StatusAccount.VERIFIED);
                    accountRepository.save(account.get());
                }
                case CLIENT -> {
                    Client client = new Client();
                    client.setUser(user);
                    clientRepository.save(client);
                    authenticationDtoResponse.setClientId(client.getId());

                    account.get().setStatus(StatusAccount.UNVERIFIED);
                    accountRepository.save(account.get());
                }
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid role: " + account.get().getRole());
        }

        return AuthenticationDtoResponse.builder()
                .accessToken(authenticationServiceImpl.generateAccessToken(account.get()))
                .userId(user.getId())
                .freelancerId(authenticationDtoResponse.getFreelancerId())
                .clientId(authenticationDtoResponse.getClientId())
                .role(account.get().getRole())
                .lat(lat)
                .lng(lng)
                .build();
    }

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

    @Override
    public Boolean banAccount(String email) {
        Optional<Account> account = accountRepository.findByEmail(email);
        if (account.isPresent()) {
            Account foundAccount = account.get();
            foundAccount.setStatus(StatusAccount.BANNED);
            accountRepository.save(foundAccount);
            return true;
        }
        return false;
    }

    @Override
    public Boolean unBanAccount(String email) {
        Optional<Account> account = accountRepository.findByEmail(email);
        if (account.isPresent()) {
            Account foundAccount = account.get();
            foundAccount.setStatus(StatusAccount.VERIFIED);
            accountRepository.save(foundAccount);
            return true;
        }

        return false;
    }

    private final LocationMapper locationMapper;

    @Override
    public List<LocationDTOResponse> getLocations() {
        return accountRepository.findAll().stream().map(locationMapper::toResponseDTO).toList();
    }
}
