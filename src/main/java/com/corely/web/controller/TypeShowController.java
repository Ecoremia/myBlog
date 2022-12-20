package com.corely.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.corely.entity.Type;
import com.corely.service.BlogService;
import com.corely.service.TypeService;
import com.corely.vo.BlogSearch;
import com.corely.vo.BlogShow;
import com.corely.vo.TypeShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 分类页
 */
@Controller
public class TypeShowController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/toType")
    public String toType(Long id, Model model){
        //先查询所有的type
        Page page = new Page<>();
        page.setSize(30);
        List<TypeShow> types = typeService.selectTypesAndCount(page);
        //设置默认查询的type
        if (id==null){
            id = types.get(0).getId();
        }
        //查询对应的blog
        BlogSearch blogSearch = new BlogSearch();
        blogSearch.setTypeId(id);
        page.setSize(10);
        page.setDesc("create_time");
        Page<BlogShow> blogList = blogService.getBlogListForShow(blogSearch, page);
        model.addAttribute("types",types);
        model.addAttribute("activiteId",id);
        model.addAttribute("blogList",blogList);
        model.addAttribute("hasPrev",blogList.hasPrevious());
        model.addAttribute("hasNext",blogList.hasNext());
        return "types";
    }
}
