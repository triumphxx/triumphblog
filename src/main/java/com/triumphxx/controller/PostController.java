package com.triumphxx.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 公众号：北漂码农有话说
 * @since 2020-05-10
 */
@Controller
public class PostController extends BaseController {
    /**
     * \\d* 指定参数类型
     * @return
     */
    @GetMapping("/category/{id:\\d*}")
    public String category(@PathVariable(name = "id") Long id){
        //控制前端点击导航栏的背景颜色
        req.setAttribute("currentCategoryId", id);
        return "post/category";
    }

    @GetMapping("/detail/{id:\\d*}")
    public String detail(@PathVariable(name = "id") Long id){
        return "post/detail";
    }
}
