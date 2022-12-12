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
        LambdaQueryWrapper<Comment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Comment::getBlogId,blogId);
        List<Comment> list = commentService.list(wrapper);
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
        comment.setCreateTime(new Date());
        User user = (User)session.getAttribute(Constants.SESSION_USER);
        if(user!=null){
            comment.setAdminComment(true);
        }else {
            comment.setAdminComment(false);
        }
        boolean save = commentService.save(comment);
        if(save==false){
            model.addAttribute("message","添加失败");
        }
        LambdaQueryWrapper<Comment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Comment::getBlogId,comment.getBlogId());
        List<Comment> list = commentService.list(wrapper);
        model.addAttribute("comments",list);
        return "blog :: commentList";
    }
}
