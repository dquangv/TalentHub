package org.example.backend.controller.account;

import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
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
import org.example.backend.service.intf.account.AccountService;
import org.example.backend.service.intf.account.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;


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
