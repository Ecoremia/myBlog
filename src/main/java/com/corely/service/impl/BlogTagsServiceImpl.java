package com.corely.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.corely.entity.BlogTags;
import com.corely.service.BlogTagsService;
import com.corely.dao.BlogTagsMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_blog_tags】的数据库操作Service实现
* @createDate 2022-10-23 17:12:00
*/
@Service
public class BlogTagsServiceImpl extends ServiceImpl<BlogTagsMapper, BlogTags>
    implements BlogTagsService{

}




