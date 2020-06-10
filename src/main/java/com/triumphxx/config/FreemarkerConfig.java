package com.triumphxx.config;

import com.jagregory.shiro.freemarker.ShiroTags;
import com.triumphxx.template.HotsTemplate;
import com.triumphxx.template.PostsTemplate;
import com.triumphxx.template.TimeAgoMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author:wangyupeng
 * @Date:2020/5/20
 * @Time:12:24
 * @desc:freemarker配置文件
 **/
@Configuration
public class FreemarkerConfig {
    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    PostsTemplate postsTemplate;

    @Autowired
    HotsTemplate hotsTemplate;

    @PostConstruct
    public void setUp() {
        configuration.setSharedVariable("timeAgo", new TimeAgoMethod());
        configuration.setSharedVariable("posts", postsTemplate);
        configuration.setSharedVariable("hots", hotsTemplate);
        configuration.setSharedVariable("shiro", new ShiroTags());
    }
}
