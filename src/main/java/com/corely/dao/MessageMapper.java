package com.corely.dao;

import com.corely.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author Administrator
* @description 针对表【t_message】的数据库操作Mapper
* @createDate 2022-10-23 17:13:21
* @Entity com.corely.entity.Message
*/
@Repository
public interface MessageMapper extends BaseMapper<Message> {

}




