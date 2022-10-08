package com.sparrow.passport.controller;

import com.alibaba.druid.util.StringUtils;
import com.sparrow.passport.entity.User;
import com.sparrow.passport.mybatis.dao.UserMybatisDao;
import com.sparrow.protocol.Controller;
import com.sparrow.protocol.LoginToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserMybatisDao userMybatisDao;

    @GetMapping("/test-auth")
    public String testAuth() {
        User o = (User) SecurityUtils.getSubject().getPrincipal();
        new Thread(new Runnable() {
            @Override public void run() {
                User o = (User) SecurityUtils.getSubject().getPrincipal();
                System.out.println(o.toString());
            }
        }).start();
        return "authentication is successful";
    }

    //    @RequestBody 不允许加 form 格式数据不支持
    @PostMapping("/login.do")
    public Boolean login(User login) {
        UsernamePasswordToken token = new UsernamePasswordToken(login.getUserName(), login.getPassword());
        token.setRememberMe(true);
        //拿到subject
        Subject subject = SecurityUtils.getSubject();
        // 执行登陆方法
        subject.login(token);
        return subject.isAuthenticated();
    }
}
