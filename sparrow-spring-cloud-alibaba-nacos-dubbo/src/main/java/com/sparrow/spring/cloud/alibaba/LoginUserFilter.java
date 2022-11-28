package com.sparrow.spring.cloud.alibaba;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class LoginUserFilter implements Filter {

    LoginUserFilter(){
        System.out.println("login filter");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
        FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            String loginTokenOfHeader = req.getHeader("login-user");
            System.out.println("login-user: " + loginTokenOfHeader);
            //ThreadContext.bindLoginToken(loginToken);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}