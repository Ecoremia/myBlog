package com.corely.web.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.corely.entity.Type;
import com.corely.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/type")
public class TypeController {
    @Autowired
    private TypeService typeService;
    //分页查询分类
    @GetMapping()
    public String getTypeByPage(Integer current, Model model){
        //设置分页显示的参数
        Page<Type> page = new Page<>();
        if (current==null){
            current = 1;
        }
        page.setCurrent(current);
        page.setSize(10);
        page.setAsc("id");
        Page<Type> typePage = typeService.getPage(page);

        model.addAttribute("page",typePage);
        model.addAttribute("hasPrev",typePage.hasPrevious());
        model.addAttribute("hasNext",typePage.hasNext());
        return "admin/adtype";
    }
    //跳转新增页面
    @GetMapping("/input")
    public String toInput(){
        return "admin/typeInput";
    }
    //新增功能实现
    @PostMapping("/save")
    public String saveType(@RequestParam String name, Model model){
        //先校验空
        Type type = new Type();
        if (StringUtils.isBlank(name)){
            model.addAttribute("message","名称不能为空");
            return "admin/typeInput";
        }
        //再校验是否重复
        Type typeByName = typeService.getTypeByName(type.getName());
        if (typeByName!=null){
            model.addAttribute("message","不能重复添加名称相同的分类");
            return "admin/typeInput";
        }
        type.setName(name);
        boolean save = typeService.save(type);
        if (save==false){
            model.addAttribute("message","操作失败，请重新尝试");
            return "admin/typeInput";
        }
        return "redirect:/admin/type";
    }
    //删除功能实现
    @GetMapping("/delete")
    public String deleteType(Long id, RedirectAttributes attributes){
        boolean remove = typeService.removeById(id);
        if (remove==false){
            attributes.addFlashAttribute("message","删除失败，请重新尝试");
            return "admin/typeInput";
        }
        return "redirect:/admin/type";
    }
    //跳转编辑页面
    @GetMapping("/toUpdate")
    public String toUpdate(Long id,Model model){
        model.addAttribute("id",id);
        return "admin/typeInput";
    }
    //实现编辑功能
    @PostMapping("/update")
    public String updateType(Type type,Model model){
        boolean error = false;
        //校验名字是否为空
        if(StringUtils.isBlank(type.getName())){
            model.addAttribute("message","分类名称不能为空");
            error =true;
        }
        //先校验是否重复
        Type typeByName = typeService.getTypeByName(type.getName());
        if (typeByName != null){
            model.addAttribute("message","不能重复添加名称相同的分类");
            error =true;
        }
        boolean b = typeService.updateById(type);
        if (b==false){
            model.addAttribute("message","新增失败");
            error =true;
        }
        if(error){
            model.addAttribute("id",type.getId());
            return  "admin/typeInput";
        }
        return "redirect:/admin/type";
    }
}
