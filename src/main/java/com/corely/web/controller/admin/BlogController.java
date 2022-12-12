package com.corely.web.controller.admin;

import com.corely.Utils.Constants;
import com.corely.entity.Type;
import com.corely.entity.User;
import com.corely.service.TypeService;
import com.corely.vo.BlogQuery;
import com.corely.vo.BlogSearch;
import org.springframework.ui.Model;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.corely.entity.Blog;
import com.corely.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;

    @RequestMapping()
    public String getBlogList(Integer current,Model model){
        List<Type> typeList = typeService.list();
        Page<BlogSearch> blogPage = new Page<>();
        if(current==null){
            current = 1;
        }
        blogPage.setCurrent(current)
                .setSize(3);
        Page<BlogQuery> page = blogService.getBlogList(blogPage, null);
        model.addAttribute("typeList",typeList);
        model.addAttribute("page",page);
        model.addAttribute("hasPrev",page.hasPrevious());
        model.addAttribute("hasNext",page.hasNext());
        return  "admin/adblog";
    }
    @PostMapping("/search")
    public String searchBlog(Integer current,BlogSearch blogSearch, Model model){
        //        查询分类和博客
        Page<BlogSearch> blogPage = new Page<>();
        if(current==null){
            current = 1;
        }
        blogPage.setCurrent(current)
                .setSize(3);
        Page<BlogQuery> page = blogService.getBlogList(blogPage, blogSearch);
        model.addAttribute("page",page);

        model.addAttribute("hasPrev",page.hasPrevious());
        model.addAttribute("hasNext",page.hasNext());
        return "admin/adblog :: blogList";
    }
    //跳转到新增页面
    @GetMapping("/input")
    public String toInput(Model model){
        model.addAttribute("types",typeService.list());
        model.addAttribute("blog",new Blog());
        return "admin/blogInput";
    }
    //跳转到编辑页面
    @GetMapping("/toUpdate")
    public String toUpdate(Long id,Model model){
        Blog blog = blogService.getById(id);
        model.addAttribute("types",typeService.list());
        model.addAttribute("blog",blog);
        return "admin/blogInput";
    }
    //新添加or修改一个blog
    @PostMapping("/save")
    public String addBlog(Blog blog, RedirectAttributes redirectAttributes, HttpSession session){
        User user  =(User) session.getAttribute(Constants.SESSION_USER);
        blog.setUserId(user.getId());
        Integer res = null;
        if(blog.getId()==null){
            res = blogService.saveBlog(blog);
        }else {
            res = blogService.updateBlog(blog);
        }
        if (res <=0){
            redirectAttributes.addFlashAttribute("message","操作失败");
        }
        return "redirect:/admin/blog";
    }
    //删除一个博客
    @GetMapping("/delete")
    public String delete(Long id,RedirectAttributes redirectAttributes){
        boolean remove = blogService.removeById(id);
        if(remove==false){
            redirectAttributes.addFlashAttribute("message","操作失败");
        }
        return "redirect:/admin/blog";
    }

}
