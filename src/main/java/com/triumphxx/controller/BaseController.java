package com.triumphxx.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.triumphxx.service.CategoryService;
import com.triumphxx.service.CommentService;
import com.triumphxx.service.PostService;
import com.triumphxx.service.UserService;
import com.triumphxx.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:triumphxx
 * @Date:2020/5/10
 * @Time:2:27 下午
 * @desc:所有controller的父类
 **/
public class BaseController {

    @Autowired
    HttpServletRequest req;

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserService userService;

    public Page getPage() {
        int pn = ServletRequestUtils.getIntParameter(req, "pn", 1);
        int size = ServletRequestUtils.getIntParameter(req, "size", 2);
        return new Page(pn, size);
    }

    protected AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }

    protected Long getProfileId() {
        return getProfile().getId();
    }
}
