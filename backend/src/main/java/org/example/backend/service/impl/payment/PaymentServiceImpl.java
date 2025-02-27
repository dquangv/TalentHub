/*
package org.example.backend.service.impl.payment;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.payment.PaymentDTORequest;
import org.example.backend.dto.response.payment.PaymentDTOResponse;
import org.example.backend.entity.child.payment.BankAccount;
import org.example.backend.entity.child.payment.EWalletAccount;
import org.example.backend.entity.child.payment.Payment;
import org.example.backend.mapper.payment.PaymentMapper;
import org.example.backend.repository.BankAccountRepository;
import org.example.backend.repository.EWalletAccountRepository;
import org.example.backend.repository.PaymentRepository;
import org.example.backend.service.intf.payment.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final EWalletAccountRepository eWalletAccountRepository;
    private final BankAccountRepository bankAccountRepository;

    private final PaymentMapper paymentMapper;

    @Override
    public PaymentDTOResponse create(PaymentDTORequest paymentDTORequest) {
        Long bankAccountId = paymentDTORequest.getBankAccountId();
        Long eWalletAccountId = paymentDTORequest.getEWalletAccountId();

        if (bankAccountId != null) {
            Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(bankAccountId);
            if (!optionalBankAccount.isPresent()) {
                throw new IllegalArgumentException("Bank account does not exist or is invalid.");
            }
            BankAccount bankAccount = optionalBankAccount.get();
            if (bankAccount.getPayment() != null) {
                throw new IllegalArgumentException("Bank account is already linked to another payment.");
            }
        }

        if (eWalletAccountId != null) {
            Optional<EWalletAccount> optionalEWalletAccount = eWalletAccountRepository.findById(eWalletAccountId);
            if (!optionalEWalletAccount.isPresent()) {
                throw new IllegalArgumentException("E-wallet account does not exist or is invalid.");
            }
            EWalletAccount eWalletAccount = optionalEWalletAccount.get();
            if (eWalletAccount.getPayment() != null) {
                throw new IllegalArgumentException("E-wallet account is already linked to another payment.");
            }
        }

        Payment payment = paymentMapper.toEntity(paymentDTORequest);

        payment = paymentRepository.save(payment);

        return paymentMapper.toDTOResponse(payment);
    }


    @Override
    public Optional<PaymentDTOResponse> getById(Long id) {
        return paymentRepository.findById(id)
                .map(paymentMapper::toDTOResponse);
    }

    @Override
    public List<PaymentDTOResponse> getAll() {
        return paymentRepository.findAll().stream()
                .map(paymentMapper::toDTOResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteById(Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
*/
