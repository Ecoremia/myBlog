package com.corely.web;

import com.corely.Utils.Constants;
import com.corely.Utils.StringUtils;
import com.corely.entity.User;
import com.corely.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String index(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes){
        User user = userService.checkUser(username, StringUtils.myMd5(password));
        if (user != null){
            user.setPassword("");
            session.setAttribute(Constants.SESSION_USER,user);
            return "admin/adindex";
        }else {
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/admin/";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(Constants.SESSION_USER);
        return "redirect:/admin/";
    }
}
