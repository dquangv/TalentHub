package org.example.backend.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class OpenApiConfig implements WebMvcConfigurer {

    @Bean
    GroupedOpenApi apiAccount() {
        return GroupedOpenApi.builder().group("Account APIs").pathsToMatch("/api/account/**")
                .packagesToScan("org.example.backend.controller").build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
