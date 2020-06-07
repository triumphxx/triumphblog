package com.triumphxx.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.triumphxx.common.lang.Result;
import com.triumphxx.entity.Category;
import com.triumphxx.entity.Post;
import com.triumphxx.util.ValidationUtil;
import com.triumphxx.vo.CommentVo;
import com.triumphxx.vo.PostVo;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


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
            int pn = ServletRequestUtils.getIntParameter(req, "pn", 1);

            //控制前端点击导航栏的背景颜色
            req.setAttribute("currentCategoryId", id);
            req.setAttribute("pn", pn);
            return "post/category";
        }

        @GetMapping("/post/{id:\\d*}")
        public String detail(@PathVariable(name = "id") Long id){

            PostVo postVo = postService.selectOnePost(new QueryWrapper<Post>()
                    .eq("p.id", id));
            Assert.notNull(postVo,"文章已经被删除");
            // 1分页，2文章id，3用户id，排序
            IPage<CommentVo> comments = commentService.paging(getPage(), postVo.getId(), null, "created");

            req.setAttribute("post", postVo);
            req.setAttribute("pageData", comments);
            return "post/detail";
        }

        @GetMapping("/post/edit")
        public String edit(){
            //获取文章的id
            String postId = req.getParameter("id");
            //根据postId查询文章是否存在
           if (StrUtil.isNotEmpty(postId)){
               Post post = postService.getById(postId);
               Assert.isTrue(post!=null,"该帖子已被删除");
               req.setAttribute("post",post);
           }
            List<Category> categories = categoryService.list();
            req.setAttribute("categories",categories);

            return "post/edit";
        }


    @ResponseBody
    @PostMapping("/post/submit")
    public Result submit(Post post){
        ValidationUtil.ValidResult validResult = ValidationUtil.validateBean(post);
        if(validResult.hasErrors()) {
            return Result.fail(validResult.getErrors());
        }
        return Result.success().action("/post/" + post.getId());
    }
}
