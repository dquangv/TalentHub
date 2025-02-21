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

    @Bean
    public GroupedOpenApi apiJob() {
        return GroupedOpenApi.builder()
                .group("Job APIs")
                .pathsToMatch("/api/v1/jobs/**")
                .build();
    }
    @Bean
    public GroupedOpenApi apiFreelancerSkill() {
        return GroupedOpenApi.builder()
                .group("FreelancerSkill APIs")
                .pathsToMatch("/api/v1/freelancer-skills/**")
                .build();
    }
    @Bean
    public GroupedOpenApi apiSkills() {
        return GroupedOpenApi.builder()
                .group("Skills APIs")
                .pathsToMatch("/api/v1/jobs/skills/**")
                .build();
    }
    @Bean
    public GroupedOpenApi apiCategory() {
        return GroupedOpenApi.builder()
                .group("Category APIs")
                .pathsToMatch("/api/v1/categories/**")
                .build();
    }
}
