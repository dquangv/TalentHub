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
import org.example.backend.enums.StatusAccount;
import org.example.backend.repository.AccountRepository;
import org.example.backend.service.impl.account.AccountServiceImpl;
import org.example.backend.service.impl.account.AuthenticationServiceImpl;
import org.example.backend.service.intf.account.AccountService;
import org.example.backend.service.intf.account.AuthenticationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.util.List;
import java.util.Map;
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

        String registrationId = ((OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication())
                .getAuthorizedClientRegistrationId();

        String email = null;

        if ("google".equals(registrationId)) {
            email = oauthUser.getAttribute("email");
        } else if ("facebook".equals(registrationId)) {
            email = oauthUser.getAttribute("id") + "@facebook.com";
        }else if ("github".equals(registrationId)) {
            email = oauthUser.getAttribute("email");
            if (email == null) {
                List<Map<String, Object>> emails = (List<Map<String, Object>>) oauthUser.getAttribute("emails");
                if (emails != null && !emails.isEmpty()) {
                    email = (String) emails.get(0).get("email");
                }
            }
        }


        Optional<Account> account = accountRepository.findByEmail(email);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (account.isPresent()) {
            if (account.get().getStatus().equals(StatusAccount.BANNED)){
                String redirectUrl = urlUI + "/banned-account-callback";
                response.sendRedirect(redirectUrl);
                return;
            }
            try {
                AuthenticationDtoResponse authenticationDtoResponse = accountServiceImpl.handleOAuth2Login(oauthUser);

                String redirectUrl = urlUI + "/oauth2-callback?accessToken=" + authenticationDtoResponse.getAccessToken()
                        + "&role=" + authenticationDtoResponse.getRole()
                        + "&clientId=" + authenticationDtoResponse.getClientId()
                        + "&freelancerId=" + authenticationDtoResponse.getFreelancerId()
                        + "&userId=" + authenticationDtoResponse.getUserId()
                        + "&lat=" + authenticationDtoResponse.getLat()
                        + "&email=" + authenticationDtoResponse.getEmail()
                        + "&lng=" + authenticationDtoResponse.getLng();

                response.sendRedirect(redirectUrl);
            } catch (JOSEException e) {
                throw new RuntimeException("Error generating JWT token", e);
            } catch (NullPointerException e) {
                e.printStackTrace();
                String redirectUrl = urlUI + "/choose-role?email=" + email;
                response.sendRedirect(redirectUrl);
            }
        } else {
            AccountDTOResponse accountDTOResponse = accountServiceImpl.handleOAuth2Register(oauthUser);

            String redirectUrl = urlUI + "/choose-role?email=" + accountDTOResponse.getEmail();
            response.sendRedirect(redirectUrl);
        }
    }

}

