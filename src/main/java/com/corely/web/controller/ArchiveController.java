package com.corely.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.corely.entity.Blog;
import com.corely.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArchiveController {
    @Autowired
    private BlogService blogService;
    @GetMapping("/toArchive")
    public String toArchive(Model model){
        //先收集年份
        List<String> years = blogService.selectYear();
        Map<String,List<Blog>> map = new HashMap<>();
        //再根据年份收集篇数
        for (String year:years){
            map.put(year, blogService.findBlogByYear(year));
        }
        model.addAttribute("records",map);
        //收集总条数
        LambdaQueryWrapper<Blog> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Blog::getPublished,"true");
        model.addAttribute("count",blogService.count(wrapper));
        return "archives";
    }
}
