
package org.example.backend.service.impl.payment;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.backend.config.vnpay.ConfigVnPay;
import org.example.backend.dto.PaymentResDTO;
import org.example.backend.dto.request.payment.PaymentDTORequest;
import org.example.backend.dto.response.ResultPaymentResponseDTO;
import org.example.backend.dto.response.payment.BalanceResponseDTO;
import org.example.backend.dto.response.payment.PaymentDTOResponse;
import org.example.backend.dto.response.payment.PaymentSummaryDTO;
import org.example.backend.dto.response.payment.WithdrawResponseDTO;
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
import java.time.LocalDate;
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
        if ("00".equals(vnp_ResponseCode)) {
            // Lấy thông tin user
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));

            // Lấy thông tin account từ user
            Account account = accountRepository.findById(user.getAccount().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Account not found"));

            // Luôn thêm mới Payment mà không kiểm tra
            Payment newPayment = new Payment();
            newPayment.setAccount(account);
            newPayment.setBalance(vnpAmount);
            newPayment.setActivity(ActivityType.DEPOSIT); // Mặc định là Nạp tiền
            paymentRepository.save(newPayment);

            System.out.println("✅ Thêm mới giao dịch thành công!");

            return ResultPaymentResponseDTO.builder()
                    .codeVnp(vnp_ResponseCode)
                    .fristName(user.getFirstName())
                    .lastName(user.getLastName())
                    .amount(vnpAmount)
                    .activity(ActivityType.DEPOSIT)
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
    public WithdrawResponseDTO handleVnPayWithCallback(BigDecimal vnpAmount, Long userId) {

        // Lấy thông tin user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Lấy thông tin account từ user
        Account account = accountRepository.findById(user.getAccount().getId())
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        // Lấy tổng số dư của tài khoản
        BigDecimal balance = paymentRepository.getTotalAmountByAccountId(account.getId());

        // Kiểm tra số dư trước khi rút tiền
        if (balance == null || balance.compareTo(vnpAmount) < 0 || balance.compareTo(BigDecimal.ZERO) == 0) {
            return WithdrawResponseDTO.builder()
                    .amount(vnpAmount)
                    .remainingBalance(balance)
                    .activityType(ActivityType.WITHDRAW)
                    .message("❌ Số dư không đủ để thực hiện giao dịch rút tiền!")
                    .status("FAILED")
                    .build();
        }

        // Tạo bản ghi mới cho giao dịch rút tiền
        Payment newPayment = new Payment();
        newPayment.setAccount(account);
        newPayment.setBalance(vnpAmount.negate()); // Số tiền rút là số âm
        newPayment.setActivity(ActivityType.WITHDRAW);
        paymentRepository.save(newPayment);

        System.out.println("✅ Giao dịch rút tiền thành công!");

        // Trả về DTO chứa thông tin giao dịch
        return WithdrawResponseDTO.builder()
                .amount(vnpAmount)
                .remainingBalance(balance)
                .activityType(ActivityType.WITHDRAW)
                .message("Giao dịch rút tiền thành công.")
                .status("SUCCESS")
                .build();
    }

    public BalanceResponseDTO getLatestBalanceInfo(Long userId) {
        // Lấy thông tin user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("❌ User không tồn tại!"));

        // Lấy thông tin account từ user
        Account account = accountRepository.findById(user.getAccount().getId())
                .orElseThrow(() -> new RuntimeException("❌ Account không tồn tại!"));

        BigDecimal balance = paymentRepository.getTotalAmountByAccountId(account.getId());

        // Lấy dữ liệu giao dịch mới nhất
        List<PaymentSummaryDTO> payments = paymentRepository.getLatestPaymentInfo(account.getId());

        // Biến để lưu giá trị cần thiết
        BigDecimal latestDeposit = BigDecimal.ZERO;
        LocalDateTime latestDepositDate = null;
        BigDecimal todaySpending = BigDecimal.ZERO;
        LocalDateTime latestSpendingDate = null;

        BigDecimal totalDepositToday = BigDecimal.ZERO;
        BigDecimal totalWithdrawToday = BigDecimal.ZERO;


        // Duyệt danh sách giao dịc
        for (PaymentSummaryDTO payment : payments) {
                if (payment.getActivity() == ActivityType.DEPOSIT) {
                    latestDeposit = totalDepositToday.add(payment.getTotalAmount());
                    latestDepositDate = payment.getLatestTransactionDate();
                } else if (payment.getActivity() == ActivityType.WITHDRAW) {
                    todaySpending =  totalWithdrawToday.add(payment.getTotalAmount());
                    latestSpendingDate = payment.getLatestTransactionDate();
                }
        }

        // Trả về DTO chứa thông tin tài khoản
        return BalanceResponseDTO.builder()
                .balance(balance)
                .latestDeposit(latestDeposit)
                .latestDepositDate(latestDepositDate)
                .todaySpending(todaySpending)
                .latestSpendingDate(latestSpendingDate)
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
