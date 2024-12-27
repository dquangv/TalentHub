package org.example.backend.service.intf.account;

import com.nimbusds.jose.JOSEException;
import org.example.backend.dto.request.account.AuthenticationDTORequest;
import org.example.backend.dto.request.account.IntrospectDTORequest;
import org.example.backend.dto.response.account.AuthenticationDtoResponse;
import org.example.backend.dto.response.account.IntrospectDtoResponse;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationDtoResponse authenticate(AuthenticationDTORequest request) throws JOSEException;
    IntrospectDtoResponse introspect(IntrospectDTORequest request) throws JOSEException, ParseException;
    AuthenticationDtoResponse refreshToken(String refreshToken) throws JOSEException, ParseException;
}
