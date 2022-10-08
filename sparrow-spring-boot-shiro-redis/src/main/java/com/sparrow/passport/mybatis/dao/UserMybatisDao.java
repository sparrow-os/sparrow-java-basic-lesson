package com.sparrow.passport.mybatis.dao;

import com.sparrow.passport.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMybatisDao {
    User queryByUserName(@Param("userName") String userName);
}
