package org.example.backend.service.impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.example.backend.entity.child.account.PasswordResetToken;
import org.example.backend.enums.EmailType;
import org.example.backend.repository.PasswordResetTokenRepository;
import org.example.backend.service.intf.EmailService;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public Boolean sendEmail(String to, EmailType emailType, String body) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        String htmlBody = createEmailBody(to, emailType, body);

        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(getSubjectForEmailType(emailType));
            helper.setText(htmlBody, true);
            mailSender.send(message);
            return true;
        } catch (MessagingException | MailException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    public Boolean sendOtpEmail(String to) {
        String otp = generateOtp();
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setOtp(otp);
        passwordResetToken.setEmail(to);
        passwordResetToken.setExpiryDate(LocalDateTime.now().plusHours(1));
        passwordResetTokenRepository.save(passwordResetToken);
        return sendEmail(to, EmailType.OTP, otp);
    }

    private String getSubjectForEmailType(EmailType emailType) {
        switch (emailType) {
            case REGISTER_SUCCESS:
                return "Welcome to Talent Hub! 🎉";
            case FREELANCER_APPROVED:
                return "Congratulations! Your Freelancer Application is Approved ✅";
            case OTP:
                return "Your OTP Code";
            case FREELANCER_REJECTED:
                return "Update on Your Freelancer Application - Talent Hub";
            case PASSWORD_RESET:
                return "Password Reset Request - Talent Hub 🔐";
            default:
                return "Talent Hub Notification";
        }
    }

    private String createEmailBody(String to, EmailType emailType, String body) {
        String baseStyle = """
            <style>
                .email-container {
                    max-width: 600px;
                    margin: 0 auto;
                    padding: 20px;
                    font-family: 'Arial', sans-serif;
                    line-height: 1.6;
                }
                .header {
                    background: linear-gradient(135deg, #6366F1 0%, #4F46E5 100%);
                    color: white;
                    padding: 30px;
                    border-radius: 10px 10px 0 0;
                    text-align: center;
                }
                .content {
                    background: #ffffff;
                    padding: 30px;
                    border-radius: 0 0 10px 10px;
                    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
                }
                .button {
                    display: inline-block;
                    padding: 12px 24px;
                    background: #4F46E5;
                    color: white;
                    text-decoration: none;
                    border-radius: 6px;
                    margin: 20px 0;
                    font-weight: bold;
                    transition: background 0.3s ease;
                }
                .footer {
                    text-align: center;
                    margin-top: 30px;
                    padding-top: 20px;
                    border-top: 1px solid #eee;
                    color: #666;
                    font-size: 14px;
                }
            </style>
            """;

        String htmlStart = """
            <html>
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                %s
            </head>
            <body style="background-color: #f4f4f5; margin: 0; padding: 20px;">
                <div class="email-container">
            """.formatted(baseStyle);

        String headerContent = """
            <div class="header">
                <div class="logo">🎯 Talent Hub</div>
            </div>
            """;

        String contentStart = "<div class=\"content\">";
        String mainContent = "";

        switch (emailType) {
            case OTP:
                mainContent = """
                    <h2 style="color: #4F46E5; margin-bottom: 20px;">Your OTP Code</h2>
                    <p>Hello %s,</p>
                    <p>Your One-Time Password (OTP) is:</p>
                    <h3 style="color: #4F46E5; font-size: 32px; text-align: center;">%s</h3>
                    <p>Please use this code to complete your action.</p>
                    <p>This OTP is valid for 5 minutes.</p>
                    """.formatted(to, body); // body here is the OTP
                break;
            // Handle other cases (like REGISTER_SUCCESS, PASSWORD_RESET, etc.) here
            default:
                mainContent = "<p>Notification email</p>";
        }

        String footer = """
                </div>
                <div class="footer">
                    <p>© 2024 Talent Hub. All rights reserved.</p>
                </div>
            </div>
            </body>
            </html>
            """;

        return htmlStart + headerContent + contentStart + mainContent + footer;
    }
}
