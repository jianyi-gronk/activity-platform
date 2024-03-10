package com.example.backend2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //
                .allowedOriginPatterns("*") //
                .allowCredentials(true) //
                .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS") //
                .allowedHeaders("*") //
                .exposedHeaders("*") //
                .maxAge(3600);
    }
}