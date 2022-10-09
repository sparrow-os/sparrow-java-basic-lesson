package com.sparrow.spring.cloud.alibaba;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties("sparrow")
public class SparrowProperties {
    @Value("${name:zhangsan}")
    private volatile String name;

    public String getName() {
        return name;
    }
}