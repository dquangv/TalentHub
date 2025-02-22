package org.example.backend.service.impl.account;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.AuthenticationDTORequest;
import org.example.backend.dto.request.account.IntrospectDTORequest;
import org.example.backend.dto.response.account.RefreshTokenDTOResponse;
import org.example.backend.dto.response.account.AuthenticationDtoResponse;
import org.example.backend.dto.response.account.IntrospectDtoResponse;
import org.example.backend.entity.child.account.Account;
import org.example.backend.entity.child.account.User;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.entity.child.account.freelancer.Freelancer;
import org.example.backend.enums.RoleUser;
import org.example.backend.exception.InvalidTokenException;
import org.example.backend.exception.TokenExpiredException;
import org.example.backend.repository.AccountRepository;
import org.example.backend.repository.ClientRepository;
import org.example.backend.repository.FreelancerRepository;
import org.example.backend.repository.UserRepository;
import org.example.backend.service.intf.account.AuthenticationService;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final FreelancerRepository freelancerRepository;
    private final ClientRepository clientRepository;

    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.secret-key}")
    protected String SECRET_KEY;
    @Override
    public AuthenticationDtoResponse authenticate(AuthenticationDTORequest request) throws JOSEException {
        String email = request.getEmail();
        System.out.println(request);

        // Lấy Account từ email, nếu không có thì ném lỗi
        Account account = accountRepository.getByEmail(email)
                .orElseThrow(() -> new IllegalIdentifierException("Tài khoản không tồn tại."));

        // Kiểm tra mật khẩu
        if (!passwordEncoder.matches(request.getPassword(), account.getPassword())) {
            log.info("Wrong password.");
            throw new IllegalIdentifierException("Mật khẩu không đúng.");
        }
        User user = userRepository.findById(account.getId())
                .orElseThrow(() -> new IllegalIdentifierException("Không tìm thấy người dùng với id: " + account.getId()));


        Long userId = user.getId();
        Long freelancerId = null;
        Long clientId = null;

        if (account.getRole().equals(RoleUser.FREELANCER)) {
            Freelancer freelancer = freelancerRepository.findByUserId(user.getId())
                    .orElseThrow(() -> new IllegalIdentifierException("Không tìm thấy freelancer với id: " + user.getId()));

            freelancerId = freelancer.getId();
        } else {
            Client client = clientRepository.findByUserId(user.getId())
                    .orElseThrow(() -> new IllegalIdentifierException("Không tìm thấy client với id: " + user.getId()));

            clientId = client.getId();
        }

        // Trả về kết quả
        return AuthenticationDtoResponse.builder()
                .accessToken(generateAccessToken(account))
                .userId(userId)
                .freelancerId(freelancerId)
                .clientId(clientId)
                .role(account.getRole())
                .build();
    }



    @Override
    public IntrospectDtoResponse introspect(IntrospectDTORequest request) throws JOSEException, ParseException {
        String accessToken = request.getAccessToken();
        verifyJWT(accessToken);
        return IntrospectDtoResponse.builder()
                .isValid(true)
                .build();
    }

    @Override
    public RefreshTokenDTOResponse refreshToken(String refreshToken) throws JOSEException, ParseException {
//        // Kiểm tra và xác thực refresh token
//        verifyRefreshToken(refreshToken);
//
//        // Tạo lại access token sau khi refresh
//            Account account = getAccountFromRefreshToken(refreshToken);
//        String accessToken = generateAccessToken(account);
//        return RefreshTokenDTOResponse.builder()
////                .accessToken(accessToken)
//                .build();
        return null;
    }


    private void verifyRefreshToken(String refreshToken) throws JOSEException {
        try {
            SignedJWT signedJWT = SignedJWT.parse(refreshToken);
            JWSVerifier verifier = new MACVerifier(SECRET_KEY.getBytes());

            if (!signedJWT.verify(verifier)) {
                throw new InvalidTokenException("Refresh Token không hợp lệ.");
            }

            // Kiểm tra thời gian hết hạn
            Date expirationTime = signedJWT.getJWTClaimsSet().getExpirationTime();
            if (expirationTime.before(new Date())) {
                throw new TokenExpiredException("Refresh Token đã hết hạn.");
            }

            // Xác minh đây là Refresh Token
            verifyTokenType(signedJWT, "refresh");
        } catch (ParseException e) {
            throw new JOSEException("Không thể parse Refresh Token.", e);
        }
    }

//    private Account getAccountFromRefreshToken(String refreshToken) throws JOSEException, ParseException {
//        // Giải mã refreshToken để lấy các claims
//        SignedJWT signedJWT = SignedJWT.parse(refreshToken);
//        JWSVerifier verifier = new MACVerifier(SECRET_KEY.getBytes());
//
//        // Xác minh refresh token hợp lệ (kiểm tra chữ ký và thời gian hết hạn)
//        if (!signedJWT.verify(verifier)) {
//            throw new JOSEException("Invalid refresh token signature.");
//        }
//
//        // Lấy các claim từ refresh token
//        JWTClaimsSet claims = signedJWT.getJWTClaimsSet();
//        String email = claims.getSubject();  // Subject là email người dùng, bạn có thể thay đổi tùy theo cách lưu trong token
//
//        // Lấy account từ cơ sở dữ liệu dựa trên email (hoặc thông tin khác từ token)
//        return accountRepository.getByEmail(email)
//                .orElseThrow(() -> new IllegalIdentifierException("Tài khoản không tồn tại."));
//    }
//
////    private String extractEmailFromToken(String refreshToken) throws JOSEException {
////        try {
////            SignedJWT signedJWT = SignedJWT.parse(refreshToken);
////            return signedJWT.getJWTClaimsSet().getSubject(); // Giả sử email được lưu trong subject
////        } catch (ParseException e) {
////            throw new ApplicationContextException("Không thể trích xuất email từ Refresh Token.", e);
////        }
////    }

    private String generateAccessToken(Account account) throws JOSEException {
        RoleUser roleName = account.getRole();
        String userName = account.getEmail();

        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(userName)
                .jwtID(generateUUID())
                .issuer("talent_hubs.com")
                .claim("type", "access") // Thêm claim "type"
                .claim("scope", roleName)
                .issueTime(new Date())
                .expirationTime(Date
                        .from(Instant.now()
                                .plus(30, ChronoUnit.DAYS))) // Ví dụ: access token hết hạn trong 30 ngày
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        jwsObject.sign(new MACSigner(SECRET_KEY.getBytes()));
        return jwsObject.serialize();
    }
    private String generateRefreshToken(Account account) throws JOSEException {
        String userName = account.getEmail();

        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(userName)
                .jwtID(generateUUID())
                .issuer("talent_hubs.com")
                .claim("type", "refresh") // Thêm claim "type"
                .issueTime(new Date())
                .expirationTime(Date.from(Instant.now().plus(30, ChronoUnit.DAYS))) // Ví dụ: refresh token hết hạn trong 30 ngày
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        jwsObject.sign(new MACSigner(SECRET_KEY.getBytes()));
        return jwsObject.serialize();
    }

    private String generateUUID() {
        return UUID.randomUUID().toString();
    }
    private SignedJWT verifyJWT(String accessToken) throws ParseException, JOSEException {
        SignedJWT signedJWT = SignedJWT.parse(accessToken);
        JWSVerifier verifier = new MACVerifier(SECRET_KEY.getBytes());

        // Kiểm tra chữ ký
        if (!signedJWT.verify(verifier)) {
            throw new InvalidTokenException("Token không hợp lệ.");
        }

        // Kiểm tra thời gian hết hạn
        Date expirationTime = signedJWT.getJWTClaimsSet().getExpirationTime();
        if (expirationTime.before(new Date())) {
            throw new TokenExpiredException("Token đã hết hạn.");
        }

        // Xác minh đây là Access Token
        verifyTokenType(signedJWT, "access");

        return signedJWT;
    }

    private void verifyTokenType(SignedJWT signedJWT, String expectedType) throws ParseException, JOSEException {
        String tokenType = signedJWT.getJWTClaimsSet().getStringClaim("type");
        if (!expectedType.equals(tokenType)) {
            throw new InvalidTokenException("Token không hợp lệ cho mục đích này.");
        }
    }

}
