package com.sparrow2.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({TestBean.class})//判断当前classpath下是否存在指定类，若是则将当前的配置装载入spring容器
@EnableConfigurationProperties(HelloServiceProperties.class)//激活自动配置（指定文件中的配置）
public class MyAutoConfiguration {
    @Autowired
    HelloServiceProperties helloServiceProperties;//注入测试的配置信息类

    @Bean
    @ConditionalOnMissingBean(TestBean.class) //当前上下文中没有TestBean实例时创建实例
    public TestBean getTestService() {
        TestBean testBean = new TestBean();
        testBean.setMsg(helloServiceProperties.getMsg());
        return testBean;
    }
}

