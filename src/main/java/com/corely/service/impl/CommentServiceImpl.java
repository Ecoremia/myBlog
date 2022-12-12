package com.corely.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.corely.entity.Comment;
import com.corely.service.CommentService;
import com.corely.dao.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_comment】的数据库操作Service实现
* @createDate 2022-10-23 17:12:56
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




