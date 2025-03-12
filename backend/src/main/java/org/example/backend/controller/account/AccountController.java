package org.example.backend.controller.account;

import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.account.*;
import org.example.backend.dto.response.account.*;
import org.example.backend.dto.request.account.AccountDTORequest;
import org.example.backend.dto.request.account.AuthenticationDTORequest;
import org.example.backend.dto.request.account.IntrospectDTORequest;
import org.example.backend.dto.response.account.RefreshTokenDTOResponse;
import org.example.backend.dto.response.account.AccountDTOResponse;
import org.example.backend.dto.response.account.AuthenticationDtoResponse;
import org.example.backend.dto.response.account.IntrospectDtoResponse;
import org.example.backend.enums.RoleUser;
import org.example.backend.exception.BadRequestException;
import org.example.backend.mapper.Account.AccountMapper;
import org.example.backend.service.intf.EmailService;
import org.example.backend.service.intf.account.AccountService;
import org.example.backend.service.intf.account.AuthenticationService;
import org.example.backend.service.intf.account.PasswordResetTokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.stream.Location;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;
    private final EmailService emailService;
    private final PasswordResetTokenService passwordResetTokenService;

    @GetMapping("/admin")
    public ResponseObject<List<AdminAccountDTOResponse>> getAllAccountByAdmin() {
        List<AdminAccountDTOResponse> response = accountService.getAllByAdmin();
        return ResponseObject
                .<List<AdminAccountDTOResponse>>builder()
                .message("Get all accounts successful")
                .status(HttpStatus.OK.value())
                .data(response)
                .build();
    }

    @PostMapping("/admin/ban")
    public ResponseObject<StatusAccountDTOResponse> banAccount(@RequestParam String email) {
        Boolean response = accountService.banAccount(email);
        return ResponseObject
                .<StatusAccountDTOResponse>builder()
                .message("Ban account")
                .status(HttpStatus.OK.value())
                .data(StatusAccountDTOResponse.builder()
                        .status(response ? "Ban account successful" : "Ban account failed")
                        .build())
                .build();
    }

    @PostMapping("/admin/unban")
    public ResponseObject<StatusAccountDTOResponse> unBanAccount(@RequestParam String email) {
        Boolean response = accountService.unBanAccount(email);
        return ResponseObject
                .<StatusAccountDTOResponse>builder()
                .message("UnBan account")
                .status(HttpStatus.OK.value())
                .data(StatusAccountDTOResponse.builder()
                        .status(response ? "Unban account successful" : "Unban account failed")
                        .build())
                .build();
    }

    @GetMapping("/locations")
    public ResponseObject<List<LocationDTOResponse>> getLocations() {
        List<LocationDTOResponse> response = accountService.getLocations();
        return ResponseObject
                .<List<LocationDTOResponse>>builder()
                .message("Get all locations successful")
                .status(HttpStatus.OK.value())
                .data(response)
                .build();
    }


    @GetMapping("/get-nearby")
    public ResponseObject<List<AccountDTOResponse>> getNearbyUsers(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam double distanceInMeters) {
        List<AccountDTOResponse> response = accountService.getNearbyUsers(lat, lon, distanceInMeters);
        return ResponseObject
                .<List<AccountDTOResponse>>builder()
                .message("Get nearby users successful")
                .status(HttpStatus.OK.value())
                .data(response)
                .build();
    }

    @PostMapping("/reset-password")
    public ResponseObject<PasswordResetTokenDTOResponse> resetPassword(@RequestBody PasswordResetTokenDTORequest passwordResetTokenDTORequest) {
        return ResponseObject.<PasswordResetTokenDTOResponse>builder().status(HttpStatus.OK.value())
                .message("Reset password successfully")
                .data(passwordResetTokenService.resetPassword(passwordResetTokenDTORequest)).build()
        ;
    }

    @PostMapping("/verify-code")
    public ResponseObject<PasswordResetTokenDTOResponse> verifyCode(@RequestBody VerifyCodeDTORequest verifyCodeDTORequest) {
        return ResponseObject.<PasswordResetTokenDTOResponse>builder().status(HttpStatus.OK.value())
                .message("Reset password successfully")
                .data(passwordResetTokenService.checkOtp(verifyCodeDTORequest)).build()
                ;
    }

    @PostMapping("/send-otp")
    public ResponseObject<String> sendOtp(@RequestParam String email) {
        if (accountService.checkEmail(email)) {
            boolean emailSent = emailService.sendOtpEmail(email);
            if (emailSent) {
                return ResponseObject.<String>builder()
                        .message("OTP sent successfully")
                        .status(HttpStatus.OK.value())
                        .data("OTP sent successfully to " + email)
                        .build();
            } else {
                return ResponseObject.<String>builder()
                        .message("Failed to send OTP")
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .build();
            }
        } else {
            return ResponseObject.<String>builder()
                    .message("Email not found")
                    .status(HttpStatus.NOT_FOUND.value())
                    .build();
        }
    }

    @GetMapping("/get-all")
    public ResponseObject<List<AccountDTOResponse>> getAll() {
        List<AccountDTOResponse> response = accountService.getAll();
        return ResponseObject
                .<List<AccountDTOResponse>>builder()
                .message("Get all account successful")
                .status(HttpStatus.OK.value())
                .data(response)
                .build();
    }

    @PostMapping("/register")
    public ResponseObject<AccountDTOResponse> register(@Valid @RequestBody AccountDTORequest request) {
        AccountDTOResponse response = accountService.create(request);
        return ResponseObject.<AccountDTOResponse>builder()
                .message("Register successful")
                .status(200)
                .data(response)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseObject<AccountDTOResponse> get(@PathVariable Long id) {
        return accountService.getById(id)
                .map(response -> ResponseObject.<AccountDTOResponse>builder()
                        .message("Get account successful by id: " + id)
                        .status(HttpStatus.OK.value())
                        .data(response)
                        .build())
                .orElse(ResponseObject.<AccountDTOResponse>builder()
                        .message("Account not found with id: " + id)
                        .status(HttpStatus.NOT_FOUND.value())
                        .build());
    }

    @PostMapping("/choose-role")
    public ResponseEntity<ResponseObject<AuthenticationDtoResponse>> chooseRole(@RequestParam String email, @RequestParam RoleUser role, @RequestParam double lat, @RequestParam double lng) throws JOSEException {
        AuthenticationDtoResponse authenticationDtoResponse = accountService.updateAccountRole(email, role, lat, lng);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseObject.<AuthenticationDtoResponse>builder()
                .message("Successfully choose role for user")
                .status(200)
                .data(authenticationDtoResponse)
                .build());
    }
}
