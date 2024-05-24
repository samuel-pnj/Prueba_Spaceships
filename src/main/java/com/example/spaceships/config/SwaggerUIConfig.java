package com.example.spaceships.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerUIConfig implements WebMvcConfigurer {

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/api").setViewName("forward:/api/");
        registry.addViewController("/api/").setViewName("forward:/api/index.html");
    }
}
