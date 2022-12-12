package com.corely.dao;

import com.corely.entity.BlogTags;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author Administrator
* @description 针对表【t_blog_tags】的数据库操作Mapper
* @createDate 2022-10-23 17:12:00
* @Entity com.corely.entity.BlogTags
*/
@Repository
public interface BlogTagsMapper extends BaseMapper<BlogTags> {

}




