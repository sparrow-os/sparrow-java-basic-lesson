package com.sparrow.passport.controller;

//import com.lesson.commons.config.wrong.ExistingClass;

import com.sparrow.passport.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //    @Autowired
//    private ExistingClass existingClass;

    @GetMapping("health")
    public String health() {
        return "health";
    }

    //    @GetMapping("swagger-resources")
//    public String swaggerResources() {
//        return "swagger-resources";
//    }
    @GetMapping("test-user")
    public User testUser() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("test");
        return user;
    }

//    @GetMapping("/**")
//    public String all() {
//        return "this is all";
//    }
}
