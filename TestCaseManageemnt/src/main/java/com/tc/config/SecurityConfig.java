
package com.tc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // ✅ Disable CSRF for testing (enable in production)
            .cors(cors -> cors.disable()) // ✅ Disable CORS restrictions
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/swagger-resources/**",
                    "/webjars/**",
                    "/v3/api-docs.yaml"
                ).permitAll()  // ✅ Allow access to Swagger API Docs
                .anyRequest().permitAll()  // ✅ TEMPORARILY allow all requests for testing
            )
            .formLogin(login -> login.disable()) // ✅ Disable login form
            .httpBasic(basic -> basic.disable()); // ✅ Disable basic auth

        return http.build();
    }
}
