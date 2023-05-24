package com.example.basketballteam.controller;

import com.example.basketballteam.model.Manager;
import com.example.basketballteam.service.ManagerService;
//import jakarta.annotation.Resource;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class LoginController {
    //创建service对象
    @Autowired
    private ManagerService managerService;

    // 发送post请求，代替了RequestMapping（value="/user/login", method="post"）
//    @PostMapping(value = "/user/login")
    // 对登录请求判断request的参数值，并存放在map中
    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(@RequestParam("id") int id,
                        @RequestParam("password") String password,
                        ModelMap map) {
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(String.valueOf(id),password);
        try {
            subject.login(token);
            return "redirect:/index";
        }catch(UnknownAccountException e){
            map.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            map.addAttribute("msg","密码错误");
            return "login";
        }
    }

}

