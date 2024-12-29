package org.example.backend.config.swagger;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GruopApiDocs {

    @Bean
    public GroupedOpenApi apiAuth() {
        return GroupedOpenApi.builder()
                .group("auth APIs")
                .pathsToMatch("/api/v1/auth/**")
                .build();
    }
    @Bean
    public GroupedOpenApi apiAccount() {
        return GroupedOpenApi.builder()
                .group("account APIs")
                .pathsToMatch("/api/v1/account/**")
                .build();
    }
}
