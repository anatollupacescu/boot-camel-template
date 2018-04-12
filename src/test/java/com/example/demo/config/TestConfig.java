package com.example.demo.config;

import org.apache.camel.component.properties.PropertiesComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public PropertiesComponent properties() {
        PropertiesComponent component = new PropertiesComponent();
        component.setLocation("application.properties");
        return component;
    }
}
