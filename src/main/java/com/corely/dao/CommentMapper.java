package com.corely.dao;

import com.corely.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author Administrator
* @description 针对表【t_comment】的数据库操作Mapper
* @createDate 2022-10-23 17:12:56
* @Entity com.corely.entity.Comment
*/
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

}




