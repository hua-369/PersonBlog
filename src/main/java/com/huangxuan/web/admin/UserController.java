package com.huangxuan.web.admin;

import com.huangxuan.po.User;
import com.huangxuan.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPassage(){
        return "admin/login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, RedirectAttributes attributes){
        User user=userService.selectUsernameAndPassword(username,password);
        if (user!=null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        }else {
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/admin";
        }
    }
    @GetMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
