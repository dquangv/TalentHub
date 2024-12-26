package org.example.backend.service.intf.account;

import com.nimbusds.jose.JOSEException;
import org.example.backend.dto.request.account.AuthenticationDtoRequest;
import org.example.backend.dto.request.account.IntrospectDtoRequest;
import org.example.backend.dto.response.account.AuthenticationDtoResponse;
import org.example.backend.dto.response.account.IntrospectDtoResponse;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationDtoResponse authenticate(AuthenticationDtoRequest request) throws JOSEException;
    IntrospectDtoResponse introspect(IntrospectDtoRequest request) throws JOSEException, ParseException;
}
