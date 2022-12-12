package com.corely.dao;

import com.corely.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author Administrator
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-10-23 17:15:00
* @Entity com.corely.entity.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

}




