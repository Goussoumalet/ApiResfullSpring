package com.blog.api.restfull;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi publicApi(){
        return  GroupedOpenApi.builder()
                .group("blog-api")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public OpenAPI apiDoc(){
        return new OpenAPI()
                .info(new Info()
                        .title("Blog Api")
                        .description("Api de gestion de blog")
                        .version("V1.0.0")
                );
    }
}
