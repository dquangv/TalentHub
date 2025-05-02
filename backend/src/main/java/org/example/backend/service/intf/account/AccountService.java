package org.example.backend.service.intf.account;

import com.nimbusds.jose.JOSEException;
import org.example.backend.dto.request.account.AccountDTORequest;
import org.example.backend.dto.response.account.AccountDTOResponse;
import org.example.backend.dto.response.account.AdminAccountDTOResponse;
import org.example.backend.dto.response.account.AuthenticationDtoResponse;
import org.example.backend.dto.response.account.LocationDTOResponse;
import org.example.backend.entity.child.account.Account;
import org.example.backend.enums.RoleUser;
import org.example.backend.service.BaseService;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

import javax.management.relation.RoleStatus;

import java.util.List;

public interface AccountService extends BaseService<AccountDTORequest, AccountDTOResponse, Long> {
    public AccountDTOResponse handleOAuth2Register(OAuth2User oauthUser);

    public AuthenticationDtoResponse handleOAuth2Login(OAuth2User oauthUser) throws JOSEException;

    public AuthenticationDtoResponse updateAccountRole(String email, RoleUser role, double lat, double lng) throws JOSEException;

    Boolean checkEmail(String email);
    boolean isPasswordSet(String email);

    public List<AdminAccountDTOResponse> getAllByAdmin();

    public List<AccountDTOResponse> getNearbyUsers(double lat, double lon, double distanceInMeters);

    Boolean banAccount(String email);

    Boolean unBanAccount(String email);

    Boolean activeAccount(String email);

    List<LocationDTOResponse> getLocations();

    boolean changePassword(String email, String currentPassword, String newPassword);

    public AuthenticationDtoResponse register(AccountDTORequest accountRequestDTO);
}

