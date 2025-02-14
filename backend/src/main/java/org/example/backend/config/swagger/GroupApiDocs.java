package org.example.backend.config.swagger;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GroupApiDocs {

    @Bean
    public GroupedOpenApi apiAuth() {
        return GroupedOpenApi.builder()
                .group("Auth APIs")
                .pathsToMatch("/api/v1/auth/**")
                .build();
    }
    @Bean
    public GroupedOpenApi apiAccount() {
        return GroupedOpenApi.builder()
                .group("Account APIs")
                .pathsToMatch("/api/v1/account/**")
                .build();
    }

    @Bean
    public GroupedOpenApi apiFreelancer() {
        return GroupedOpenApi.builder()
                .group("Freelancer APIs")
                .pathsToMatch("/api/v1/freelancers/**")
                .build();
    }
}
