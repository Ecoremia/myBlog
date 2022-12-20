package com.corely.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.corely.entity.Comment;
import com.corely.service.CommentService;
import com.corely.dao.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_comment】的数据库操作Service实现
* @createDate 2022-10-23 17:12:56
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> selectCommentByBlogId(Long blogId) {
        //先查询所有的根评论
        List<Comment> comments = commentMapper.selectRootComment(blogId);
        //再查询是否有子评论
        for(Comment rootComment:comments){
            List<Comment> childComments = commentMapper.selectChildComment(blogId, rootComment.getId());
            //如果有子评论则去添加
            if(childComments!=null){
                //给每一个子评论添加父评论的名字
                childComments = handleChildComment(childComments);
                rootComment.setReplyComments(childComments);
            }
        }
        return comments;
    }

    @Override
    public Integer insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Override
    public Comment selectCommentById(Long id) {
        return commentMapper.selectCommentById(id);
    }

    //处理每一个子节点
    public List<Comment> handleChildComment(List<Comment> childComments){
        for(Comment comment : childComments){
            String parNickname = commentMapper.selectNicknameById(comment.getParentCommentId());
            comment.setParentNickname(parNickname);
        }
        return childComments;
    }
}




