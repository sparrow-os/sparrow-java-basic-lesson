package com.sparrow.spring.cloud.alibaba;

import com.sparrow.spring.cloud.alibaba.api.Dubbo2Service;
import com.sparrow.spring.cloud.alibaba.api.DubboService;
import com.sparrow.spring.cloud.alibaba.api.LoginParam;
import org.apache.dubbo.config.annotation.Service;

@Service(protocol = "dubbo")
public class Dubbo2ServiceImpl implements Dubbo2Service {
    @Override
    public String test(String param) {
        System.out.println(param);
        return "rest service: " + param;
    }
}
