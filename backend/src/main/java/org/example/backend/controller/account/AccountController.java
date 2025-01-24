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
import org.example.backend.mapper.Account.AccountMapper;
import org.example.backend.service.intf.account.AccountService;
import org.example.backend.service.intf.account.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

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
                .status(HttpStatus.OK.value())
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


}
