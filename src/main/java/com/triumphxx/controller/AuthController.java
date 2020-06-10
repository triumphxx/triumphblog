package com.triumphxx.controller;

import cn.hutool.crypto.SecureUtil;
import com.google.code.kaptcha.Producer;
import com.triumphxx.common.lang.Result;
import com.triumphxx.entity.User;
import com.triumphxx.util.ValidationUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class AuthController extends BaseController {

    private static final String KAPTCHA_SESSION_KEY = "KAPTCHA_SESSION_KEY";

    @Autowired
    Producer producer;

    @GetMapping("/capthca.jpg")
    public void kaptcha(HttpServletResponse resp) throws IOException {

        // 验证码
        String text = producer.createText();
        BufferedImage image = producer.createImage(text);
        req.getSession().setAttribute(KAPTCHA_SESSION_KEY, text);

        resp.setHeader("Cache-Control", "no-store, no-cache");
        resp.setContentType("image/jpeg");
        ServletOutputStream outputStream = resp.getOutputStream();
        ImageIO.write(image, "jpg", outputStream);
    }

    @GetMapping("/login")
    public String login() {

        return "/auth/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Result doLogin(String email,String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(email, SecureUtil.md5(password));
        SecurityUtils.getSubject().login(token);
        return Result.success().action("/");
    }

    @GetMapping("/register")
    public String register() {
        return "/auth/reg";
    }

    @PostMapping("/register")
    @ResponseBody
    public Result toRegister(User user,String repass,String vercode) {
        //校验非空
        ValidationUtil.ValidResult validResult = ValidationUtil.validateBean(user);
        if(validResult.hasErrors()) {
            return Result.fail(validResult.getErrors());
        }
        //判断俩次密码是否一样
        if (!user.getPassword().endsWith(repass)){
            return Result.fail("俩次密码输入不一致，请重新输入");
        }

        //校验验证码
        String code = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);

        if (!code.equalsIgnoreCase(vercode)){
            return Result.fail("验证码输入有误，请重新输入");
        }

        Result result = userService.register(user);

        return result.action("/login");
    }


    @RequestMapping("/user/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/";
    }


}
