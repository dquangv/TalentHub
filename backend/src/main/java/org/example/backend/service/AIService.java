package org.example.backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;
import java.time.LocalDateTime;

@Service
public class AIService {

    private static final Logger log = LoggerFactory.getLogger(AIService.class);

    @Value("${ollama.url}")
    private String ollamaUrl;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Gọi Ollama để phát hiện intent từ câu hỏi
     */
    public String callOllamaForIntentDetection(String prompt) throws Exception {
        return callOllamaModel(prompt, "mistral");
    }

    /**
     * Gọi Ollama để tạo phản hồi dựa trên intent
     */
    public String callOllamaForResponseGeneration(String prompt) throws Exception {
        return callOllamaModel(prompt, "mistral");
    }


    /**
     * Phương thức chung để gọi Ollama API
     */
    private String callOllamaModel(String prompt, String model) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> payload = Map.of(
                "model", model,
                "prompt", prompt,
                "stream", false  // Đặt false để nhận phản hồi đầy đủ
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(payload, headers);

        try {
            ResponseEntity<Map> response = restTemplate.exchange(
                    ollamaUrl + "/api/generate",
                    HttpMethod.POST,
                    request,
                    Map.class
            );

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return (String) response.getBody().get("response");
            } else {
                throw new RuntimeException("Unsuccessful API call, status: " + response.getStatusCode());
            }
        } catch (Exception e) {
            log.error("Error calling Ollama API: {}", e.getMessage());
            throw e;
        }
    }
}