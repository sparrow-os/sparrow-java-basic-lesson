package com.sparrow.spring.cloud.alibaba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${name:zhangsan}")
    private String name;

    @Autowired
    SparrowProperties sparrowProperties;

    /**
     * http://localhost:8001/config/get
     */
    @RequestMapping("/get")
    public String get() {
        return name + "property's key" + this.sparrowProperties.getName();
    }
}