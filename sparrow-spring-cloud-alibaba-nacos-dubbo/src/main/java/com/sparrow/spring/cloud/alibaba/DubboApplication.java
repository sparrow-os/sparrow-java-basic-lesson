package com.sparrow.spring.cloud.alibaba;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DubboApplication {

    public static void main(String[] args) {
        /**
         * 必须disable
         * dubbo
         */
        new SpringApplicationBuilder(DubboApplication.class)
            .web(WebApplicationType.SERVLET)
            .run(args);
    }
}


