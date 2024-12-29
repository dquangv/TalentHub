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
import org.example.backend.exception.InvalidTokenException;
import org.example.backend.exception.TokenExpiredException;
import org.example.backend.repository.AccountRepository;
import org.example.backend.service.intf.account.AuthenticationService;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContextException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder jwtDecoder;

    @Value("${jwt.secret-key}")
    protected String SECRET_KEY;

    @Override
    public AuthenticationDtoResponse authenticate(AuthenticationDTORequest request) throws JOSEException {
        String email = request.getEmail();
        System.out.println(request);
        var account = accountRepository.getByEmail(email).orElseThrow(
                () -> new IllegalIdentifierException("Tài khoản không tồn tại."));

        boolean authenticated = jwtDecoder.matches(request.getPassword()
                , account.getPassword());
        if (!authenticated) throw new IllegalIdentifierException("Mật khẩu không đúng.");

        return AuthenticationDtoResponse.builder()
                .accessToken(generateAccessToken(account))
                .refreshToken(generateRefreshToken(account))
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
        // Kiểm tra và xác thực refresh token
        verifyRefreshToken(refreshToken);

        // Tạo lại access token sau khi refresh
            Account account = getAccountFromRefreshToken(refreshToken);
        String accessToken = generateAccessToken(account);
        return RefreshTokenDTOResponse.builder()
                .accessToken(accessToken)
                .build();
    }


    private void verifyRefreshToken(String refreshToken) throws JOSEException {
        try {
            SignedJWT signedJWT = SignedJWT.parse(refreshToken);
            JWSVerifier verifier = new MACVerifier(SECRET_KEY.getBytes());

            if (!signedJWT.verify(verifier)) {
                throw new ApplicationContextException("Refresh Token không hợp lệ.");
            }

            // Kiểm tra thời gian hết hạn của refresh token
            Date expirationTime = signedJWT.getJWTClaimsSet().getExpirationTime();
            if (expirationTime.before(new Date())) {
                throw new ApplicationContextException("Refresh Token đã hết hạn.");
            }
        } catch (ParseException e) {
            throw new ApplicationContextException("Không thể parse Refresh Token.", e);
        }
    }
    private Account getAccountFromRefreshToken(String refreshToken) throws JOSEException, ParseException {
        // Giải mã refreshToken để lấy các claims
        SignedJWT signedJWT = SignedJWT.parse(refreshToken);
        JWSVerifier verifier = new MACVerifier(SECRET_KEY.getBytes());

        // Xác minh refresh token hợp lệ (kiểm tra chữ ký và thời gian hết hạn)
        if (!signedJWT.verify(verifier)) {
            throw new JOSEException("Invalid refresh token signature.");
        }

        // Lấy các claim từ refresh token
        JWTClaimsSet claims = signedJWT.getJWTClaimsSet();
        String email = claims.getSubject();  // Subject là email người dùng, bạn có thể thay đổi tùy theo cách lưu trong token

        // Lấy account từ cơ sở dữ liệu dựa trên email (hoặc thông tin khác từ token)
        return accountRepository.getByEmail(email)
                .orElseThrow(() -> new IllegalIdentifierException("Tài khoản không tồn tại."));
    }

//    private String extractEmailFromToken(String refreshToken) throws JOSEException {
//        try {
//            SignedJWT signedJWT = SignedJWT.parse(refreshToken);
//            return signedJWT.getJWTClaimsSet().getSubject(); // Giả sử email được lưu trong subject
//        } catch (ParseException e) {
//            throw new ApplicationContextException("Không thể trích xuất email từ Refresh Token.", e);
//        }
//    }

    private String generateAccessToken(Account account) throws JOSEException {
        String roleName = account.getRole();
        String userName = account.getEmail();

        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(userName)
                .jwtID(generateUUID())
                .issuer("talent_hubs.com")
                .claim("scope", roleName)
                .issueTime(new Date())
                .expirationTime(Date
                        .from(Instant.now()
                                .plus(1, ChronoUnit.MINUTES)))
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
                .issueTime(new Date())
                .expirationTime(Date.from(Instant.now().plus(2, ChronoUnit.MINUTES))) // Ví dụ: refresh token hết hạn trong 30 ngày
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

        Date expirationTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        // Kiểm tra xem token đã hết hạn hay chưa
        boolean isExpired = expirationTime.before(new Date());

        // Kiểm tra tính hợp lệ của token
        boolean isVerified = signedJWT.verify(verifier);

        // Nếu token hết hạn hoặc không hợp lệ, ném ngoại lệ riêng biệt
        if (isExpired) {
            throw new TokenExpiredException("Token đã hết hạn.");
        } else if (!isVerified) {
            throw new InvalidTokenException("Token không hợp lệ.");
        }

        return signedJWT;
    }

}
