package com.baizhi.dao;

import com.baizhi.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;//提供了各种CRUD方法
import org.springframework.stereotype.Component;

//使用mybatis-plus增强接口
@Component
public interface UserDAO extends BaseMapper<User> {

}