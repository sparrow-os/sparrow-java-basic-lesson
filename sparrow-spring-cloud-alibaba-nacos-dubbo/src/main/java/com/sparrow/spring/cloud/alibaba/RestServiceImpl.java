package com.sparrow.spring.cloud.alibaba;

import com.sparrow.spring.cloud.alibaba.api.LoginParam;
import com.sparrow.spring.cloud.alibaba.api.RestService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.apache.dubbo.config.annotation.Service;

@Service(protocol = "rest")
@Path("/")
public class RestServiceImpl implements RestService {
    @Override
    @Path("test/{p}")
    @GET
    public String test(@PathParam("p") String param) {
        System.out.println(param);
        return "rest service: " + param;
    }

    @Path("login")
    @POST
    @Override public LoginParam login(LoginParam loginParam) {
        System.out.println(loginParam.getPassword());
        return loginParam;
    }
}
