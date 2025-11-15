package com.mindora.platform.shared.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // Desactiva CSRF (por ahora, para facilitar pruebas con POST/PUT desde clientes externos)
                .csrf(AbstractHttpConfigurer::disable)

                // No queremos sesiones de servidor por ahora (estilo API stateless)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // Todo el mundo puede acceder a todo, sin login
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )

                // Desactiva formulario de login por defecto
                .formLogin(AbstractHttpConfigurer::disable)

                // Desactiva basic auth (el popup feo del navegador)
                .httpBasic(AbstractHttpConfigurer::disable);

        return http.build();
    }
}