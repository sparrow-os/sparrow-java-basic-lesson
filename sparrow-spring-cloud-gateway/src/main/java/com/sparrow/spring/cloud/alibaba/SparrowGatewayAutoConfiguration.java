package com.sparrow.spring.cloud.alibaba;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SparrowGatewayAutoConfiguration {
    @Bean
    public RedPacketIdRoutePredicateFactory redPackageIdRoutePredicateFactory() {
        return new RedPacketIdRoutePredicateFactory();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HealthExamination healthExamination() {
        return new HealthExamination(restTemplate());
    }
}
