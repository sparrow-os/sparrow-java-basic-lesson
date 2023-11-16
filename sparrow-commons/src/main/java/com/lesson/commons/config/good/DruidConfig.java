package com.lesson.commons.config.good;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(DruidDataSource.class)
public class DruidConfig {
    @Bean(name = "sparrow_default")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }
}
