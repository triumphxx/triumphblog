package com.triumphxx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:triumphxx
 * @Date:2020/5/9
 * @Time:9:37 下午
 * @desc:首页控制器
 **/
@Controller
public class IndexController extends BaseController {
    @RequestMapping({"","/","index"})
    public String index(){

        // 分页信息 分类信息  用户信息 置顶 精华 排序
        IPage results = postService.paging(getPage(),null,null,null,null,"created");

        req.setAttribute("pageData", results);
        req.setAttribute("currentCategoryId", 0);
        return "index";
    }
}
