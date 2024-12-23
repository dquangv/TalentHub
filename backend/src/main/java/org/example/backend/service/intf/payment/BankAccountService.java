package org.example.backend.service.intf.payment;

import org.example.backend.dto.request.payment.BankAccountRequest;
import org.example.backend.entity.child.payment.BankAccount;
import org.example.backend.service.BaseService;

public interface BankAccountService extends BaseService<BankAccountRequest,Long> {
}
