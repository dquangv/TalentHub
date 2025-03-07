package org.example.backend.exception;

import com.google.api.gax.rpc.NotFoundException;
import org.example.backend.dto.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Xử lý NotFoundException
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFoundException(NotFoundException ex, WebRequest request) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("status", HttpStatus.NOT_FOUND.value());
        errorDetails.put("message", ex.getMessage());
        errorDetails.put("timestamp", System.currentTimeMillis());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // Xử lý BadRequestException
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseObject<Object>> handleBadException(BadRequestException ex) {
        ResponseObject<Object> responseObject = ResponseObject.builder()
                .message("Bad Request")
                .status(HttpStatus.BAD_REQUEST.value())
                .data(ex.getMessage())
                .build();

        return ResponseEntity.badRequest().body(responseObject);
    }



    // Xử lý Exception tổng quát
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex, WebRequest request) {
        ex.printStackTrace();
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDetails.put("message", "Internal Server Error: " + ex.getMessage());
        errorDetails.put("timestamp", System.currentTimeMillis());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    // Xử lý ngoại lệ khi token hết hạn
    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<Map<String, Object>> handleTokenExpired(TokenExpiredException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("statusCode", HttpStatus.UNAUTHORIZED.value());
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("error", "Token Expired");
        errorResponse.put("timestamp", System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    // Xử lý ngoại lệ khi token không hợp lệ
    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidToken(InvalidTokenException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("statusCode", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("error", "Invalid Token");
        errorResponse.put("timestamp", System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
