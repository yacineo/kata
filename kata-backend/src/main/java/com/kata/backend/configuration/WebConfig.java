package com.kata.backend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig class implements WebMvcConfigurer to customize the configuration of the FOOBARQUIX Web MVC.
 * It currently provides CORS (Cross-Origin Resource Sharing) configuration for the application.
 *
 * <p>This class is annotated with @Configuration, indicating that it is a source of bean definitions.
 *
 * <p>Methods:
 * <ul>
 *   <li>{@link #addCorsMappings(CorsRegistry)} - Configures CORS settings allowing specific origins, methods, and headers.
 * </ul>
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {




    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Authorization", "Content-Type")
                .allowCredentials(true);
    }
}
