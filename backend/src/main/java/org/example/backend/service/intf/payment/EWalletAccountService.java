package org.example.backend.service.intf.payment;

import org.example.backend.dto.request.payment.EWalletAccountDTORequest;
import org.example.backend.dto.response.payment.EWalletAccountDTOResponse;
import org.example.backend.service.BaseService;

public interface EWalletAccountService extends BaseService<EWalletAccountDTORequest, EWalletAccountDTOResponse, Long> {
}
