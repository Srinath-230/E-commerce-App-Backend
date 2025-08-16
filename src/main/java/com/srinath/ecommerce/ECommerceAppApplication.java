package com.srinath.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ECommerceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceAppApplication.class, args);
    }

    /**
     * This bean configures CORS for the entire application.
     * It allows all API endpoints and the contact form to accept
     * requests from all origins.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Configure CORS for all API endpoints
                registry.addMapping("/api/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");

                // Configure CORS for the contact form endpoint
                registry.addMapping("/contact")
                        .allowedOrigins("*")
                        .allowedMethods("POST", "OPTIONS");
            }
        };
    }
}
