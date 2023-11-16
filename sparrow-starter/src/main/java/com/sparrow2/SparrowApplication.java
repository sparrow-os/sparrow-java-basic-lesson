package com.sparrow2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.sparrow2"})
public class SparrowApplication {
    public static void main(String[] args) {
        SpringApplication.run(SparrowApplication.class, args);
    }
}
