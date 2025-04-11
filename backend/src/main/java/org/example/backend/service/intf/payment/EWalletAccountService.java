package org.example.backend.service.intf.payment;

import org.example.backend.dto.request.payment.EWalletAccountDTORequest;
import org.example.backend.dto.response.payment.EWalletAccountDTOResponse;
import org.example.backend.service.BaseService;

import java.util.Optional;

public interface EWalletAccountService extends BaseService<EWalletAccountDTORequest, EWalletAccountDTOResponse, Long> {
    Optional<EWalletAccountDTOResponse> getByPhoneNumber(String phoneNumber);

    Optional<EWalletAccountDTOResponse> getByEmail(String email);

}
