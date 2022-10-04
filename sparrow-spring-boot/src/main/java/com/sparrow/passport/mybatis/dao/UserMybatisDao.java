package com.sparrow.passport.mybatis.dao;

import com.sparrow.passport.entity.User;

public interface UserMybatisDao {
    User queryByUserName(String userName);
}
