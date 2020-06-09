package com.triumphxx.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController extends BaseController {

    @GetMapping("/login")
    public String login() {
        return "/auth/login";
    }


    @GetMapping("/register")
    public String register() {
        return "/auth/reg";
    }


    @RequestMapping("/user/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/";
    }

}
