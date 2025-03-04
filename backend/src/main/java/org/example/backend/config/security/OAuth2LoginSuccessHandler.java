package org.example.backend.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.JOSEException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.AccountDTORequest;
import org.example.backend.dto.response.account.AccountDTOResponse;
import org.example.backend.dto.response.account.AuthenticationDtoResponse;
import org.example.backend.entity.child.account.Account;
import org.example.backend.enums.RoleUser;
import org.example.backend.repository.AccountRepository;
import org.example.backend.service.impl.account.AccountServiceImpl;
import org.example.backend.service.impl.account.AuthenticationServiceImpl;
import org.example.backend.service.intf.account.AccountService;
import org.example.backend.service.intf.account.AuthenticationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final AccountRepository accountRepository;
    private final AuthenticationServiceImpl authenticationService;
    private final AccountServiceImpl accountServiceImpl;
    @Value("${ui.url}")
    private String urlUI;


    //http://localhost:8080/oauth2/authorization/google
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        OAuth2User oauthUser = (OAuth2User) authentication.getPrincipal();
        String email = oauthUser.getAttribute("email");
        Optional<Account> account = accountRepository.findByEmail(email);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (account.isPresent()) {
            try {
                AuthenticationDtoResponse authenticationDtoResponse = accountServiceImpl.handleOAuth2Login(oauthUser);

//                new ObjectMapper().writeValue(response.getOutputStream(), authenticationDtoResponse);
                String redirectUrl = urlUI + "/oauth2-callback?accessToken=" + authenticationDtoResponse.getAccessToken()
                        + "&role=" + authenticationDtoResponse.getRole()
                        + "&clientId=" + authenticationDtoResponse.getClientId()
                        + "&freelancerId=" + authenticationDtoResponse.getFreelancerId()
                        + "&userId=" + authenticationDtoResponse.getUserId()
                        + "&lat=" + authenticationDtoResponse.getLat()
                        +"&lng=" + authenticationDtoResponse.getLng();
                response.sendRedirect(redirectUrl);
            } catch (JOSEException e) {
                throw new RuntimeException(e);
            }
        } else {
            AccountDTOResponse accountDTOResponse = accountServiceImpl.handleOAuth2Register(oauthUser);

//            new ObjectMapper().writeValue(response.getOutputStream(), accountDTOResponse);
            String redirectUrl = urlUI + "/choose-role?email=" + email;
            response.sendRedirect(redirectUrl);
        }
    }
}

