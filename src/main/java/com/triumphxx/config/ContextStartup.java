package com.triumphxx.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.triumphxx.entity.Category;
import com.triumphxx.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * @author:triumphxx
 * @Date:2020/5/10
 * @Time:7:40 下午
 * @desc:应用级别数据缓存
 **/
@Component
public class ContextStartup  implements ApplicationRunner, ServletContextAware {
    @Autowired
    CategoryService categoryService;

    ServletContext servletContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Category> categories = categoryService.list(new QueryWrapper<Category>()
                .eq("status", 0)
        );
        servletContext.setAttribute("categorys", categories);

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
