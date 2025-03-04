package org.example.backend.service.intf.account;

import org.example.backend.dto.request.account.AccountDTORequest;
import org.example.backend.dto.response.account.AccountDTOResponse;
import org.example.backend.dto.response.account.AdminAccountDTOResponse;
import org.example.backend.service.BaseService;

import java.util.List;

public interface AccountService extends BaseService<AccountDTORequest, AccountDTOResponse, Long> {
    Boolean checkEmail (String email);
    public List<AdminAccountDTOResponse> getAllByAdmin();
    public List<AccountDTOResponse> getNearbyUsers(double lat, double lon, double distanceInMeters);
    Boolean banAccount(String email);
    Boolean unBanAccount(String email);

}

