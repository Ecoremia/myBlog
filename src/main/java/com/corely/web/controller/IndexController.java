package com.corely.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.corely.Utils.MarkdownUtils;
import com.corely.entity.Blog;
import com.corely.service.BlogService;
import com.corely.service.TypeService;
import com.corely.vo.BlogDetail;
import com.corely.vo.TypeShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 博客首页的controlller
 */
@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    //跳转到博客首页
    @GetMapping("/")
    public String index(Model model,Integer current){
        /**
         * 首页还有很多内容没展示。可以好好考虑一下自己究竟想要展示什么内容
         */
        //显示分类
        Page page = new Page<>();
        page.setSize(6);
        page.setDesc("count");
        List<TypeShow> types = typeService.selectTypesAndCount(page);
        //显示最新推荐

        //显示博客
        if(current==null){
            current = 1;
        }
        page.setCurrent(current);
        page.setDesc("create_time");
        page.setSize(10);
        model.addAttribute("types",types);
        model.addAttribute("page",blogService.getBlogListForShow(page));
        model.addAttribute("hasPrev",page.hasPrevious());
        model.addAttribute("hasNext",page.hasNext());

        return "index";
    }
    //博客详情页
    @GetMapping("/toBlogDetail")
    public String blog(Long id,Model model){
        BlogDetail blog = blogService.getBlogDetailById(id);
        //需要对博客的markdown编辑下的内容进行一个对应转化
        blog.setContent(MarkdownUtils.markdownToHtml(blog.getContent()));
        model.addAttribute("blog",blog);
        return "blog";
    }
    @PostMapping("/search")
    public String searchBlog(String query,Model model){
        Page<Object> page = new Page<>();
        page.setCurrent(1);
        page.setDesc("create_time");
        page.setSize(10);
        model.addAttribute("page",blogService.getBlogListByQuery(query,page));
        model.addAttribute("hasPrev",page.hasPrevious());
        model.addAttribute("hasNext",page.hasNext());
        model.addAttribute("query",query);
        return "search";
    }
    //跳转到博客关于我页面
    @GetMapping("/toAboutMe")
    public String toAboutMe(){
        return "aboutMe";
    }
}
