package org.example.backend.controller.account;

import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.account.AuthenticationDTORequest;
import org.example.backend.dto.request.account.IntrospectDTORequest;
import org.example.backend.dto.response.account.AuthenticationDtoResponse;
import org.example.backend.dto.response.account.IntrospectDtoResponse;
import org.example.backend.dto.response.account.RefreshTokenDTOResponse;
import org.example.backend.service.intf.account.AuthenticationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseObject<AuthenticationDtoResponse> authenticate(@Valid @RequestBody AuthenticationDTORequest request) throws JOSEException {
        AuthenticationDtoResponse response = authenticationService.authenticate(request);

        return ResponseObject.<AuthenticationDtoResponse>builder()
                .result(true)
                .message("Login successful")
                .status(200)
                .data(response)
                .build();
    }
    @PostMapping("/refresh-token")
    public ResponseObject<RefreshTokenDTOResponse> refreshToken(@RequestParam String refreshToken) throws JOSEException, ParseException {
        RefreshTokenDTOResponse response = authenticationService.refreshToken(refreshToken);
        return ResponseObject.<RefreshTokenDTOResponse>builder()
                .result(true)
                .message("Refresh token successful")
                .status(200)
                .data(response)
                .build();
    }
    @PostMapping("/introspect")
    public ResponseObject<IntrospectDtoResponse> introspect(@RequestBody IntrospectDTORequest accessToken) throws JOSEException, ParseException {
        IntrospectDtoResponse response = authenticationService.introspect(accessToken);
        return ResponseObject.<IntrospectDtoResponse>builder()
                .result(true)
                .message("Introspect token successful")
                .status(200)
                .data(response)
                .build();
    }
}
