package com.lesson.commons.config.wrong;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ClassNotFoundConfig {
    @Bean
    public ExistingClass existingClass() {
        return new ExistingClass();
    }
    @Bean(name = "sparrow_default")
    @ConditionalOnClass(DruidDataSource.class)
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }
}
