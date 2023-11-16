package com.sparrow2.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    private static final String MSG = "hello world";
    private String msg = MSG;

    public static String getMSG() {
        return MSG;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
