package org.example.backend.service.intf;

import org.example.backend.dto.request.account.freelancer.CVDTORequest;
import org.example.backend.dto.response.account.freelancer.CVDTOResponse;
import org.example.backend.enums.EmailType;
import org.example.backend.service.BaseService;

public interface EmailService {
    Boolean sendEmail(String to, EmailType emailType, String body);

    Boolean sendOtpEmail(String to);
}
