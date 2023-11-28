package com.lesson.commons.config.wrong;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
//@ConditionalOnClass(DruidDataSource.class)
public class ClassNotFoundConfig {

    @Bean
    @ConditionalOnClass(DruidDataSource.class)
    public DruidDataSource existingClass() {
        return new DruidDataSource();
    }

//    @Configuration(proxyBeanMethods = false)
//    @ConditionalOnClass(DruidDataSource.class)
//    static class DruidDataSource {
//        @Bean(name = "sparrow_default")
//        public DruidDataSource druidDataSource() {
//            return new DruidDataSource();
//        }
//    }
}
