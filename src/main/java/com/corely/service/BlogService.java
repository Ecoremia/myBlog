package com.corely.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.corely.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.corely.vo.BlogDetail;
import com.corely.vo.BlogQuery;
import com.corely.vo.BlogSearch;
import com.corely.vo.BlogShow;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_blog】的数据库操作Service
* @createDate 2022-10-23 17:10:46
*/
public interface BlogService extends IService<Blog> {
    //管理页面的blog列表
    public Page<BlogQuery> getBlogList(Page<BlogSearch> page, BlogSearch blogSearch);
    int saveBlog(Blog blog);
    int updateBlog(Blog blog);
    //我有一种感觉，那就是这几个方法可以合并一下
    //主页的blog列表
    public Page<BlogShow> getBlogListForShow(Page page);
    //全局搜索
    public Page<BlogShow> getBlogListByQuery(String query,Page page);
    //博客详情
    public BlogDetail getBlogDetailById(Long id);
    //查询分类页/归档页/标签页的博客列表
    public Page<BlogShow> getBlogListForShow(BlogSearch blogSearch,Page page);
    //收集文章的年份
    public List<String> selectYear();
    //根据年份收集博客信息
    public List<Blog> findBlogByYear(String year);
}
