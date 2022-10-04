package com.sparrow.passport.controller;

import com.sparrow.passport.entity.User;
import com.sparrow.passport.mybatis.dao.UserMybatisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserMybatisDao userMybatisDao;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        logger.info(user.getUserName());
        return "hello world";
    }
}
