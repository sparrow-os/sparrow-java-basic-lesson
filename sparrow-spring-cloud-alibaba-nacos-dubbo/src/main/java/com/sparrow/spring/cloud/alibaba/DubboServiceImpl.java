package com.sparrow.spring.cloud.alibaba;

import com.sparrow.spring.cloud.alibaba.api.LoginParam;
import com.sparrow.spring.cloud.alibaba.api.DubboService;
import org.apache.dubbo.config.annotation.Service;

@Service(protocol = "dubbo")
public class DubboServiceImpl implements DubboService {
    @Override
    public String test(String param) {
        System.out.println(param);
        return "rest service: " + param;
    }

    @Override public LoginParam login(LoginParam loginParam) {
        System.out.println(loginParam.getPassword());
        return loginParam;
    }
}
