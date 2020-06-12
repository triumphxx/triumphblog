package com.triumphxx.controller;


import com.triumphxx.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 公众号：北漂码农有话说
 * @since 2020-05-10
 */
@Controller
public class UserController extends BaseController {

    @GetMapping("user/set")
    public String set(){
        return "auth/set";
    }

    @GetMapping("user/home")
    public String home(){
        User user = userService.getById(getProfileId());
        req.setAttribute("user",user);

        return "auth/home";
    }

    @GetMapping("user/index")
    public String index(){
        return "auth/index";
    }

    @GetMapping("user/message")
    public String message(){
        return "auth/message";
    }
}
