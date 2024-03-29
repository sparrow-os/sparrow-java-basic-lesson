//package com.sparrow.passport.controller;
//
//import com.sparrow.passport.entity.User;
//import com.sparrow.passport.mybatis.dao.UserMybatisDao;
//import com.sparrow.protocol.dao.StatusCriteria;
//import com.sparrow.protocol.enums.StatusRecord;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class LoginController {
//    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
//    @Autowired
//    private UserMybatisDao userMybatisDao;
//
//    @PostMapping("/login")
//    public String login(@RequestBody User user) {
//        if (StringUtils.isEmpty(user.getUserName())) {
//            return "user name is empty";
//        }
//        if (StringUtils.isEmpty(user.getPassword())) {
//            return "password is empty";
//        }
//        logger.info(user.getUserName());
//        User oldUser = this.userMybatisDao.queryByUserName(user.getUserName());
//        StatusCriteria statusCriteria = new StatusCriteria("64,65", StatusRecord.ENABLE);
//        userMybatisDao.updateUser(statusCriteria);
//        if (oldUser == null) {
//            return "user not found!!";
//        }
//        if (!user.getPassword().equals(oldUser.getPassword())) {
//            return "password not match";
//        }
//        return "login successful";
//    }
//}
