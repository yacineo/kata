package com.kata.backend.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Autoriser CORS pour toutes les ressources
        registry.addMapping("/**")  // Applique à toutes les routes
                .allowedOrigins("http://localhost:4200")  // Frontend Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Méthodes HTTP autorisées
                .allowedHeaders("*")  // Autoriser tous les en-têtes
                .allowCredentials(true);  // Autoriser les informations d'identification
    }
}
