
package org.example.backend.service.impl.payment;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.formula.functions.Now;
import org.example.backend.config.vnpay.ConfigVnPay;
import org.example.backend.dto.PaymentResDTO;
import org.example.backend.dto.request.payment.PaymentDTORequest;
import org.example.backend.dto.response.ResultPaymentResponseDTO;
import org.example.backend.dto.response.payment.PaymentDTOResponse;
import org.example.backend.entity.child.account.Account;
import org.example.backend.entity.child.account.User;
import org.example.backend.entity.child.payment.Payment;
import org.example.backend.enums.ActivityType;
import org.example.backend.repository.AccountRepository;
import org.example.backend.repository.PaymentRepository;
import org.example.backend.repository.UserRepository;
import org.example.backend.service.intf.payment.PaymentService;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final HttpServletRequest httpServletRequest;

    private final UserRepository userRepository;

    private final AccountRepository accountRepository;

    private final PaymentRepository paymentRepository;

    public PaymentResDTO createVnPayPayment(BigDecimal amount) throws UnsupportedEncodingException {
        String vnp_TxnRef = ConfigVnPay.getRandomNumber(8);
        BigDecimal totalAmount = amount.multiply(BigDecimal.valueOf(100));


        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", ConfigVnPay.vnp_Version);
        vnp_Params.put("vnp_Command", ConfigVnPay.vnp_Command);
        vnp_Params.put("vnp_TmnCode", ConfigVnPay.vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(totalAmount));
        vnp_Params.put("vnp_CurrCode", "VND");
        vnp_Params.put("vnp_BankCode", "NCB");
        vnp_Params.put("vnp_OrderType", "other");
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang: " + vnp_TxnRef);
        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_ReturnUrl", ConfigVnPay.vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", httpServletRequest.getRemoteAddr());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));

        vnp_Params.put("vnp_CreateDate", formatter.format(cld.getTime()));
        cld.add(Calendar.MINUTE, 15);
        vnp_Params.put("vnp_ExpireDate", formatter.format(cld.getTime()));

        String queryUrl = buildQueryString(vnp_Params);
        String vnp_SecureHash = ConfigVnPay.hmacSHA512(ConfigVnPay.secretKey, queryUrl);
        String paymentUrl = ConfigVnPay.vnp_PayUrl + "?" + queryUrl + "&vnp_SecureHash=" + vnp_SecureHash;

        return PaymentResDTO.builder()
                .status("success")
                .message("Payment URL generated successfully")
                .url(paymentUrl)
                .build();
    }

    private String buildQueryString(Map<String, String> vnp_Params) throws UnsupportedEncodingException {
        List<String> fieldNames = new ArrayList<>(vnp_Params.keySet());
        Collections.sort(fieldNames);

        StringBuilder query = new StringBuilder();
        for (int i = 0; i < fieldNames.size(); i++) {
            String fieldName = fieldNames.get(i);
            String fieldValue = vnp_Params.get(fieldName);
            if (fieldValue != null && !fieldValue.isEmpty()) {
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()))
                        .append("=")
                        .append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (i < fieldNames.size() - 1) {
                    query.append("&");
                }
            }
        }
        return query.toString();
    }
    public ResultPaymentResponseDTO handleVnPayCallback(String vnp_ResponseCode, BigDecimal vnpAmount, Long userId) {
        if (vnp_ResponseCode.equals("00")) {
            // Lấy thông tin user
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));

            // Lấy thông tin account từ user
            Account account = accountRepository.findById(user.getAccount().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Account not found"));

            Payment payment = account.getPayment();

            ActivityType AcctivityType = ActivityType.DEPOSIT;

            if (payment != null) {
                // Nếu Payment đã tồn tại, cập nhật số dư
                payment.setBalance(payment.getBalance().add(vnpAmount));
                paymentRepository.save(payment);
                System.out.println("Cập nhật số dư tài khoản thành công.");
            } else {
                // Nếu chưa có Payment, tạo mới
                Payment newPayment = new Payment();
                newPayment.setAccount(account);
                newPayment.setBalance(vnpAmount);
                newPayment.setUpdatedAt(LocalDateTime.now());
                newPayment.setActivity(AcctivityType);
                paymentRepository.save(newPayment);
                // Cập nhật lại Account với Payment mới
                account.setPayment(newPayment);
                accountRepository.save(account);
                System.out.println("Tạo mới tài khoản thanh toán thành công.");
            }
            return ResultPaymentResponseDTO.builder()
                    .codeVnp(vnp_ResponseCode)
                    .fristName(user.getFirstName())
                    .lastName(user.getLastName())
                    .amount(vnpAmount)
                    .activity(AcctivityType)
                    .build();
        }

        return ResultPaymentResponseDTO.builder()
                .codeVnp(vnp_ResponseCode)
                .fristName(null)
                .lastName(null)
                .amount(null)
                .activity(null)
                .build();

    }



    @Override
    public PaymentDTOResponse create(PaymentDTORequest paymentDTORequest) {
        return null;
    }

    @Override
    public Optional<PaymentDTOResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<PaymentDTOResponse> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }


//    private final PaymentRepository paymentRepository;
//    private final EWalletAccountRepository eWalletAccountRepository;
//    private final BankAccountRepository bankAccountRepository;
//
//    private final PaymentMapper paymentMapper;
//
//    @Override
//    public PaymentDTOResponse create(PaymentDTORequest paymentDTORequest) {
//        Long bankAccountId = paymentDTORequest.getBankAccountId();
//        Long eWalletAccountId = paymentDTORequest.getEWalletAccountId();
//
//        if (bankAccountId != null) {
//            Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(bankAccountId);
//            if (!optionalBankAccount.isPresent()) {
//                throw new IllegalArgumentException("Bank account does not exist or is invalid.");
//            }
//            BankAccount bankAccount = optionalBankAccount.get();
//            if (bankAccount.getPayment() != null) {
//                throw new IllegalArgumentException("Bank account is already linked to another payment.");
//            }
//        }
//
//        if (eWalletAccountId != null) {
//            Optional<EWalletAccount> optionalEWalletAccount = eWalletAccountRepository.findById(eWalletAccountId);
//            if (!optionalEWalletAccount.isPresent()) {
//                throw new IllegalArgumentException("E-wallet account does not exist or is invalid.");
//            }
//            EWalletAccount eWalletAccount = optionalEWalletAccount.get();
//            if (eWalletAccount.getPayment() != null) {
//                throw new IllegalArgumentException("E-wallet account is already linked to another payment.");
//            }
//        }
//
//        Payment payment = paymentMapper.toEntity(paymentDTORequest);
//
//        payment = paymentRepository.save(payment);
//
//        return paymentMapper.toDTOResponse(payment);
//    }
//
//
//    @Override
//    public Optional<PaymentDTOResponse> getById(Long id) {
//        return paymentRepository.findById(id)
//                .map(paymentMapper::toDTOResponse);
//    }
//
//    @Override
//    public List<PaymentDTOResponse> getAll() {
//        return paymentRepository.findAll().stream()
//                .map(paymentMapper::toDTOResponse)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Boolean deleteById(Long id) {
//        if (paymentRepository.existsById(id)) {
//            paymentRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
}
