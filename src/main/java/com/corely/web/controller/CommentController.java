package com.corely.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.corely.Utils.Constants;
import com.corely.entity.Comment;
import com.corely.entity.User;
import com.corely.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    //刷新comment列表
    @GetMapping("/comments")
    public String getCommentList(Long blogId, Model model){
        List<Comment> list = commentService.selectCommentByBlogId(blogId);
        model.addAttribute("comments",list);
        return "blog :: commentList";
    }

    //新增comment
    @PostMapping("/comments/add")
    public String addComment(Comment comment, HttpSession session, Model model){
        //记得给他们设置头像
        if(comment.getParentCommentId()==-1){
            comment.setParentCommentId(null);
        }
        comment = setCommentRootId(comment);
        comment.setCreateTime(new Date());
        //设置是否为管理员评论
        User user = (User)session.getAttribute(Constants.SESSION_USER);
        if(user!=null){
            comment.setAdminComment(true);
        }else {
            comment.setAdminComment(false);
        }
        Integer integer = commentService.insertComment(comment);
        if(integer<=0){
            model.addAttribute("message","添加失败");
        }
        List<Comment> list = commentService.selectCommentByBlogId(comment.getBlogId());
        model.addAttribute("comments",list);
        return "blog :: commentList";
    }
    //一个为了设置rootid的方法
    public Comment setCommentRootId(Comment comment){
        //如果没有父评论，直接返回
        if (comment.getParentCommentId()==null){
            return comment;
        }
        //如果有父评论，则查询父评论
        Comment parComment = commentService.selectCommentById(comment.getParentCommentId());
        //如果父评论没有父评论--->第一个评论
        if(parComment.getParentCommentId()==null){
            comment.setRootCommentId(parComment.getId());
        }else {
            comment.setRootCommentId(parComment.getRootCommentId());
        }
        return comment;
    }
}
