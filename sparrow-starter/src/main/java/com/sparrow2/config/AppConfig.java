package com.sparrow2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class AppConfig {
    @Bean
    public Address address() {
        System.out.println("init address");
        return new Address();
    }

    @Bean
    public User user() {
        Address address = new Address();
        return new User();
    }
}
