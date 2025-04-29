package org.example.backend;
import com.nimbusds.jose.JOSEException;
import org.example.backend.controller.account.AuthController;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.account.AuthenticationDTORequest;
import org.example.backend.dto.response.account.AuthenticationDtoResponse;
import org.example.backend.enums.RoleUser;
import org.example.backend.service.intf.account.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void testAuthenticate_InvalidInput_ThrowsJOSEException() throws JOSEException {
        AuthenticationDTORequest request = AuthenticationDTORequest.builder()
                .email("invalid-email")
                .password("password123")
                .build();

        when(authenticationService.authenticate(request)).thenThrow(new JOSEException("Invalid token generation"));

        assertThrows(JOSEException.class, () -> authController.authenticate(request));

        verify(authenticationService, times(1)).authenticate(request);
    }

    @Test
    void testAuthenticate_EmptyEmail_ValidationFailure() throws JOSEException {
        AuthenticationDTORequest request = AuthenticationDTORequest.builder()
                .email("")
                .password("password123")
                .build();

        when(authenticationService.authenticate(request)).thenThrow(new IllegalArgumentException("Email is required"));

        assertThrows(IllegalArgumentException.class, () -> authController.authenticate(request));

        verify(authenticationService, times(1)).authenticate(request);
    }

    @Test
    void testAuthenticate_NullRequest_ValidationFailure() throws JOSEException {
        when(authenticationService.authenticate(null)).thenThrow(new NullPointerException("Request cannot be null"));

        assertThrows(NullPointerException.class, () -> authController.authenticate(null));

        verify(authenticationService, times(1)).authenticate(null);
    }
}