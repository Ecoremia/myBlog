package com.corely.dao;

import com.corely.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_comment】的数据库操作Mapper
* @createDate 2022-10-23 17:12:56
* @Entity com.corely.entity.Comment
*/
@Repository
public interface CommentMapper extends BaseMapper<Comment> {
    //查询一级评论（根节点为空）
    List<Comment> selectRootComment(Long blogId);
    //查询二级评论（根节点不为空）
    List<Comment> selectChildComment(Long blogId,Long rootCommentId);
    //根据id查询评论人的名字
    String selectNicknameById(Long id);
    //添加一条评论
    Integer insertComment(Comment comment);
    //根据id查询一整条评论
    Comment selectCommentById(Long id);
}




