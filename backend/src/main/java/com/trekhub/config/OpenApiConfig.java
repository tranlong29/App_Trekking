package com.trekhub.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("TrekBook VN (TrekHub) API Documentation")
                        .version("1.0.0")
                        .description("RESTful APIs cho Mạng xã hội Trekking, Leo núi và Du lịch dã ngoại chuyên sâu tại Việt Nam")
                        .contact(new Contact()
                                .name("TrekBook VN Team")
                                .email("contact@trekbook.vn"))
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")));
    }
}
