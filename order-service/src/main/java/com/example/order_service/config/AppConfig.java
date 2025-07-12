package com.example.order_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Value("${service.api.account.url}")
    private String accountBaseUrl;
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public String getAccountBaseUrl() {
        return accountBaseUrl;
    }
}
