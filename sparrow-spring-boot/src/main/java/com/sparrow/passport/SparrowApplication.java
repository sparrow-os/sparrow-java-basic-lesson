package com.sparrow.passport;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.sparrow.passport.mybatis.dao")
public class SparrowApplication {
    public static void main(String[] args) {
        SpringApplication.run(SparrowApplication.class, args);
    }
}
