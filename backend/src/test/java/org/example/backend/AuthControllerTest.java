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
    void testAuthenticate_ValidAccount_Success() throws JOSEException {
        AuthenticationDTORequest request = AuthenticationDTORequest.builder()
                .email("tiendqpc07858@fpt.edu.vn")
                .password("1234")
                .lat(0.0)
                .lng(0.0)
                .build();

        AuthenticationDtoResponse serviceResponse = AuthenticationDtoResponse.builder()
                .accessToken("mocked_access_token_tiendq")
                .userId(1L)
                .freelancerId(null)
                .clientId(null)
                .role(RoleUser.FREELANCER)
                .lat(0.0)
                .lng(0.0)
                .email("tiendqpc07858@fpt.edu.vn")
                .build();

        when(authenticationService.authenticate(request)).thenReturn(serviceResponse);

        ResponseObject<AuthenticationDtoResponse> response = authController.authenticate(request);

        assertNotNull(response);
        assertEquals("Login successful", response.getMessage());
        assertEquals(200, response.getStatus());
        assertEquals(serviceResponse, response.getData());
        assertEquals("tiendqpc07858@fpt.edu.vn", response.getData().getEmail());
        assertEquals("mocked_access_token_tiendq", response.getData().getAccessToken());

        verify(authenticationService, times(1)).authenticate(request);
    }

    @Test
    void testAuthenticate_Success() throws JOSEException {
        AuthenticationDTORequest request = AuthenticationDTORequest.builder()
                .email("huydqpc07859@example.com")
                .password("1234")
                .lat(10.0)
                .lng(20.0)
                .build();

        AuthenticationDtoResponse serviceResponse = AuthenticationDtoResponse.builder()
                .accessToken("mocked_access_token")
                .userId(1L)
                .freelancerId(null)
                .clientId(2L)
                .role(RoleUser.CLIENT)
                .lat(10.0)
                .lng(20.0)
                .email("test@example.com")
                .build();

        when(authenticationService.authenticate(request)).thenReturn(serviceResponse);

        ResponseObject<AuthenticationDtoResponse> response = authController.authenticate(request);

        assertNotNull(response);
        assertEquals("Login successful", response.getMessage());
        assertEquals(200, response.getStatus());
        assertEquals(serviceResponse, response.getData());

        verify(authenticationService, times(1)).authenticate(request);
    }

}