package org.example.backend.service.intf.payment;

import org.example.backend.dto.request.payment.EWalletAccountRequest;
import org.example.backend.entity.child.payment.EWalletAccount;
import org.example.backend.service.BaseService;

public interface EWalletAccountService extends BaseService<EWalletAccountRequest,Long> {
}
