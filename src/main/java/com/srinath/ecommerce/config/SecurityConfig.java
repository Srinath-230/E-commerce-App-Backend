package com.srinath.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /**
     * This bean configures the security filter chain.
     * We are temporarily disabling all security to allow you to build and test
     * the core functionality of your e-commerce application without any
     * authentication or authorization requirements.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // This line tells Spring to permit all requests to any URL
                .authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll())
                // This line disables CSRF protection, which is required when security is off
                .csrf(csrf -> csrf.disable());
        return http.build();
    }
}
