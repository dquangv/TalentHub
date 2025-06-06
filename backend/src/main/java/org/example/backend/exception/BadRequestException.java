package org.example.backend.exception;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = -5774145765965871404L;
    private final int statusCode;

    public BadRequestException(String message) {
        super(message);
        this.statusCode = HttpServletResponse.SC_BAD_REQUEST;
    }

    public BadRequestException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
