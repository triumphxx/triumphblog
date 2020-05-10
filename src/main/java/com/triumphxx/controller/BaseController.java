package com.triumphxx.controller;

import com.triumphxx.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

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
}
