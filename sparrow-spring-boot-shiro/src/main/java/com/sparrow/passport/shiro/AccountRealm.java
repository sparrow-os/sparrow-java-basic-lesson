package com.sparrow.passport.shiro;

import com.sparrow.passport.entity.User;
import com.sparrow.passport.mybatis.dao.UserMybatisDao;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class AccountRealm extends AuthorizingRealm {

    private UserMybatisDao userMybatisDao;

    public AccountRealm(UserMybatisDao userMybatisDao) {
        this.userMybatisDao = userMybatisDao;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
        AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        User user = userMybatisDao.queryByUserName(usernamePasswordToken.getUsername());
        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        }
//        if (!user.getPassword().equals(new String(usernamePasswordToken.getPassword()))) {
//            throw new IncorrectCredentialsException("密码错误");
//        }
        return new SimpleAuthenticationInfo(user, usernamePasswordToken.getCredentials(), getName());
    }
}
