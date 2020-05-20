package com.triumphxx.config;

import com.jagregory.shiro.freemarker.ShiroTags;
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
    @PostConstruct
    public void setUp() {
        configuration.setSharedVariable("timeAgo", new TimeAgoMethod());
    }
}
