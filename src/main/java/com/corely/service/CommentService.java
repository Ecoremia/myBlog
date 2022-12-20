package com.corely.service;

import com.corely.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_comment】的数据库操作Service
* @createDate 2022-10-23 17:12:56
*/
public interface CommentService extends IService<Comment> {
    List<Comment> selectCommentByBlogId(Long blogId);
    //添加一条新评论
    Integer insertComment(Comment comment);
    //根据id查询一整条评论
    Comment selectCommentById(Long id);
}
