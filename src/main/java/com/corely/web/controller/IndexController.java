package com.corely.web.controller;

import com.corely.handler.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }
    @GetMapping("/archives")
    public String archives(){
        return "archives";
    }
    @GetMapping("/tags")
    public String tags(){
        return "tags";
    }
    @GetMapping("/types")
    public String types(){
        return "types";
    }
    @GetMapping("/admin/blog")
    public String adblog(){
        return "admin/adblog";
    }
    @GetMapping("/admin/input")
    public String adinput(){
        return "admin/adinput";
    }
}
