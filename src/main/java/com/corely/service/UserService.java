package com.corely.service;

import com.corely.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【t_user】的数据库操作Service
* @createDate 2022-10-23 17:15:00
*/
public interface UserService extends IService<User> {
    /**
     * 根据密码和用户名查询用户
     */
    User checkUser(String username,String password);
}
