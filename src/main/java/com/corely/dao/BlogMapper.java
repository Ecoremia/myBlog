package com.corely.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.corely.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.corely.vo.BlogDetail;
import com.corely.vo.BlogQuery;
import com.corely.vo.BlogSearch;
import com.corely.vo.BlogShow;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_blog】的数据库操作Mapper
* @createDate 2022-10-23 17:10:46
* @Entity com.corely.entity.Blog
*/
@Repository
public interface BlogMapper extends BaseMapper<Blog> {
    //管理员页面查找blog列表
    Page<BlogQuery> selectBlogByCondition(Page<BlogSearch> page,BlogSearch blogSearch);
    //首页查找Blog列表
    Page<BlogShow> selectBlogForShow(Page page);
    //全局搜索
    public Page<BlogShow> getBlogListByQuery(String query, Page page);
    //博客详情
    public BlogDetail getBlogDetailById(Long id);
    //查询分类页/归档页/标签页的博客列表
    public Page<BlogShow> getBlogListForCertainShow(BlogSearch blogSearch,Page page);
    //查询年份
    List<String> selectYear();
    //根据年份查询对应的博客
    List<Blog> findBlogByYear(String year);
}




