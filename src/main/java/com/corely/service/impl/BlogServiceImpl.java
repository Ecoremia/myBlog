package com.corely.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.corely.entity.Blog;
import com.corely.service.BlogService;
import com.corely.dao.BlogMapper;
import com.corely.vo.BlogDetail;
import com.corely.vo.BlogQuery;
import com.corely.vo.BlogSearch;
import com.corely.vo.BlogShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【t_blog】的数据库操作Service实现
* @createDate 2022-10-23 17:10:46
*/
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog>
    implements BlogService{
    @Autowired
    private BlogMapper blogMapper;
    @Override
    public Page<BlogQuery> getBlogList(Page<BlogSearch> page, BlogSearch blogSearch) {
        return blogMapper.selectBlogByCondition(page,blogSearch);
    }

    @Transactional
    @Override
    public int saveBlog(Blog blog) {
        if(blog.getShareStatement()==null){
            blog.setShareStatement(false);
        }
        if(blog.getCommentabled()==null){
            blog.setCommentabled(false);
        }
        if(blog.getRecommend()==null){
            blog.setRecommend(false);
        }
        if(blog.getAppreciation()==null){
            blog.setAppreciation(false);
        }
        blog.setCreateTime(new Date());
        blog.setViews("0");
        return blogMapper.insert(blog);
    }

    @Override
    public int updateBlog(Blog blog) {
        blog.setUpdateTime(new Date());
        return blogMapper.updateById(blog);
    }

    @Override
    public Page<BlogShow> getBlogListForShow(Page page) {
        return blogMapper.selectBlogForShow(page);
    }

    @Override
    public Page<BlogShow> getBlogListByQuery(String query, Page page) {
        return blogMapper.getBlogListByQuery(query,page);
    }

    @Override
    public BlogDetail getBlogDetailById(Long id) {
        return blogMapper.getBlogDetailById(id);
    }

    @Override
    public Page<BlogShow> getBlogListForShow(BlogSearch blogSearch, Page page) {
        return blogMapper.getBlogListForCertainShow(blogSearch,page);
    }

    @Override
    public List<String> selectYear() {
        return blogMapper.selectYear();
    }

    @Override
    public List<Blog> findBlogByYear(String year) {
        return blogMapper.findBlogByYear(year);
    }
}




