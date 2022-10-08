package com.sparrow.passport.servlet;

import com.sparrow.passport.dao.UserDao;
import com.sparrow.passport.entity.User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginServlet implements Servlet {
    private static Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    @Override public void init(ServletConfig config) throws ServletException {
        logger.info("init");
    }

    @Override public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        logger.info("userName={}", userName);
        logger.info("password={}", password);
        UserDao userDao = new UserDao();
        User user = null;
        try {
            user = userDao.getUserByUserName(userName,password);
        } catch (SQLException ex) {
            logger.error("query user by user name error", ex);
        }
        if (user == null) {
            logger.error("[{}] user not found!", userName);
            response.getWriter().write("user  not found");
            return;
        }
//        if (!user.getPassword().equals(password)) {
//            logger.error("user password not match, 用户输入的密码为{}，数据库密码为{}", password, user.getPassword());
//            response.getWriter().write("user password not match");
//
//            return;
//        }
        response.getWriter().write("user login successful");
    }

    @Override public String getServletInfo() {
        return null;
    }

    @Override public void destroy() {

    }
}
