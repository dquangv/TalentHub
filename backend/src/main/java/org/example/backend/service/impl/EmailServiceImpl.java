package org.example.backend.service.impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.example.backend.enums.EmailType;
import org.example.backend.service.intf.EmailService;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

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

    private String getSubjectForEmailType(EmailType emailType) {
        switch (emailType) {
            case REGISTER_SUCCESS:
                return "Welcome to Talent Hub! 🎉";
            case FREELANCER_APPROVED:
                return "Congratulations! Your Freelancer Application is Approved ✅";
            case PASSWORD_RESET:
                return "Password Reset Request - Talent Hub 🔐";
            case FREELANCER_REJECTED:
                return "Update on Your Freelancer Application - Talent Hub";
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
                .button:hover {
                    background: #4338CA;
                }
                .footer {
                    text-align: center;
                    margin-top: 30px;
                    padding-top: 20px;
                    border-top: 1px solid #eee;
                    color: #666;
                    font-size: 14px;
                }
                .logo {
                    font-size: 24px;
                    font-weight: bold;
                    margin-bottom: 10px;
                }
                .social-links {
                    margin-top: 20px;
                }
                .social-links a {
                    color: #666;
                    text-decoration: none;
                    margin: 0 10px;
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
            case REGISTER_SUCCESS:
                mainContent = """
                    <h2 style="color: #4F46E5; margin-bottom: 20px;">Welcome to Talent Hub! 🎉</h2>
                    <p>Hello %s,</p>
                    <p>We're thrilled to have you join our community! Your registration was successful, and you're now part of a growing network of talented professionals.</p>
                    <p>Here's what you can do next:</p>
                    <ul style="padding-left: 20px;">
                        <li>Complete your profile</li>
                        <li>Browse available projects</li>
                        <li>Connect with other professionals</li>
                    </ul>
                    <a href="#" class="button">Get Started</a>
                    """.formatted(to);
                break;
            case FREELANCER_APPROVED:
                mainContent = """
                    <h2 style="color: #4F46E5; margin-bottom: 20px;">Congratulations! 🌟</h2>
                    <p>Hello %s,</p>
                    <p>Great news! Your application to become a freelancer on Talent Hub has been approved. We're excited to see what you'll bring to our community.</p>
                    <p>You now have access to:</p>
                    <ul style="padding-left: 20px;">
                        <li>Project bidding</li>
                        <li>Advanced search features</li>
                        <li>Freelancer dashboard</li>
                    </ul>
                    <a href="#" class="button">Start Bidding</a>
                    """.formatted(to);
                break;
            case PASSWORD_RESET:
                mainContent = """
                    <h2 style="color: #4F46E5; margin-bottom: 20px;">Password Reset Request 🔐</h2>
                    <p>Hello %s,</p>
                    <p>We received a request to reset your password. If you didn't make this request, please ignore this email.</p>
                    <p>To reset your password, click the button below:</p>
                    <a href="%s" class="button">Reset Password</a>
                    <p style="color: #666; font-size: 14px;">This link will expire in 24 hours.</p>
                    """.formatted(to, body);
                break;
            case FREELANCER_REJECTED:
                mainContent = """
                    <h2 style="color: #4F46E5; margin-bottom: 20px;">Application Update</h2>
                    <p>Hello %s,</p>
                    <p>Thank you for your interest in becoming a freelancer on Talent Hub. After careful review of your application, we regret to inform you that we are unable to approve your request at this time.</p>
                    <p>We encourage you to:</p>
                    <ul style="padding-left: 20px;">
                        <li>Review our freelancer guidelines</li>
                        <li>Enhance your profile and portfolio</li>
                        <li>Apply again in 30 days</li>
                    </ul>
                    <p>We appreciate your understanding and wish you the best in your professional journey.</p>
                    """.formatted(to);
                break;
            default:
                mainContent = """
                    <h2 style="color: #4F46E5; margin-bottom: 20px;">Notification</h2>
                    <p>Hello %s,</p>
                    <p>You have a new notification from Talent Hub.</p>
                    """.formatted(to);
        }

        String footer = """
                </div>
                <div class="footer">
                    <p>© 2024 Talent Hub. All rights reserved.</p>
                    <div class="social-links">
                        <a href="#">Twitter</a> |
                        <a href="#">LinkedIn</a> |
                        <a href="#">Facebook</a>
                    </div>
                    <p style="color: #999; font-size: 12px; margin-top: 20px;">
                        This is an automated message. Please do not reply to this email.
                    </p>
                </div>
            </div>
            </body>
            </html>
            """;

        return htmlStart + headerContent + contentStart + mainContent + footer;
    }
}