package com.sparrow.spring.cloud.alibaba;

import com.sparrow.spring.cloud.alibaba.api.DubboService;
import javax.websocket.server.PathParam;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HelloController {

    @Reference
    private DubboService dubboService;

    @RequestMapping("/hello")
    public String hello() {
        String dubboResult = dubboService.test("test dubbo");
        return "hello " + dubboResult;
    }

    @RequestMapping("/test/hello")
    public String test() {
        String dubboResult = dubboService.test("test dubbo");
        return " test dubbo hello " + dubboResult;
    }
}
