package org.example.backend.service.intf.payment;

import org.example.backend.dto.request.payment.TransactionsDTORequest;
import org.example.backend.dto.response.payment.TransactionsDTOResponse;
import org.example.backend.service.BaseService;

import java.util.List;


public interface TransactionsService extends BaseService<TransactionsDTORequest, TransactionsDTOResponse, Long> {
    List<TransactionsDTOResponse> getTransactionsByAccountId(Long accountId);
}
