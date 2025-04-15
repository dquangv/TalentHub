package org.example.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
public class AIService {
    private static final Logger logger = LoggerFactory.getLogger(AIService.class);

    @Value("${ollama.url}")
    private String ollamaUrl;

    @Autowired
    private RestTemplate restTemplate;

    // Cache cho các truy vấn AI
    private ConcurrentHashMap<String, CachedResponse> responseCache = new ConcurrentHashMap<>();
    private static final long CACHE_EXPIRY_TIME = TimeUnit.HOURS.toMillis(1); // 1 giờ

    /**
     * Gọi Ollama để phát hiện intent
     */
    public String callOllamaForIntentDetection(String prompt) {
        // Kiểm tra cache
        String cacheKey = "intent_" + prompt.hashCode();
        CachedResponse cachedResponse = responseCache.get(cacheKey);

        if (cachedResponse != null && !isCacheExpired(cachedResponse)) {
            logger.info("Intent detection cache hit for prompt hash: {}", prompt.hashCode());
            return cachedResponse.getResponse();
        }

        logger.info("Calling Ollama API for intent detection");
        String response = callOllamaApi(prompt);

        // Lưu vào cache
        responseCache.put(cacheKey, new CachedResponse(response, System.currentTimeMillis()));

        return response;
    }

    /**
     * Gọi Ollama để tạo câu trả lời
     */
    public String callOllamaForResponseGeneration(String prompt) {
        // Không cache câu trả lời để đảm bảo sự đa dạng
        logger.info("Calling Ollama API for response generation");
        return callOllamaApi(prompt);
    }

    /**
     * Gọi API Ollama
     */
    private String callOllamaApi(String prompt) {
        try {
            String url = ollamaUrl + "/api/generate";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "mistral");  // Hoặc tên model khác mà bạn đang sử dụng
            requestBody.put("prompt", prompt);
            requestBody.put("stream", false);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<Map> response = restTemplate.postForEntity(url, entity, Map.class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return (String) response.getBody().get("response");
            } else {
                logger.error("Error response from Ollama API: {}", response);
                throw new RuntimeException("Failed to get valid response from Ollama API");
            }
        } catch (Exception e) {
            logger.error("Error calling Ollama API: {}", e.getMessage(), e);
            throw new RuntimeException("Error calling Ollama API: " + e.getMessage(), e);
        }
    }

    private boolean isCacheExpired(CachedResponse cachedResponse) {
        return System.currentTimeMillis() - cachedResponse.getTimestamp() > CACHE_EXPIRY_TIME;
    }

    /**
     * Lớp nội bộ để lưu trữ kết quả cache và thời gian
     */
    private static class CachedResponse {
        private final String response;
        private final long timestamp;

        public CachedResponse(String response, long timestamp) {
            this.response = response;
            this.timestamp = timestamp;
        }

        public String getResponse() {
            return response;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }
}