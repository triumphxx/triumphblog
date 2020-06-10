package com.triumphxx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.triumphxx.common.lang.Result;
import com.triumphxx.entity.Post;
import com.triumphxx.util.ValidationUtil;
import com.triumphxx.vo.CommentVo;
import com.triumphxx.vo.PostVo;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


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
            String id = req.getParameter("id");
            if(!StringUtils.isEmpty(id)) {
                Post post = postService.getById(id);
                Assert.isTrue(post != null, "改帖子已被删除");
                Assert.isTrue(post.getUserId().longValue() == getProfileId().longValue(), "没权限操作此文章");
                req.setAttribute("post", post);
            }
            req.setAttribute("categories", categoryService.list());
            return "/post/edit";
        }


    @ResponseBody
    @PostMapping("/post/submit")
    public Result submit(Post post){
        ValidationUtil.ValidResult validResult = ValidationUtil.validateBean(post);
        if(validResult.hasErrors()) {
            return Result.fail(validResult.getErrors());
        }

        if(post.getId() == null) {
            post.setUserId(getProfileId());

            post.setModified(new Date());
            post.setCreated(new Date());
            post.setCommentCount(0);
            post.setEditMode(null);
            post.setLevel(0);
            post.setRecommend(false);
            post.setViewCount(0);
            post.setVoteDown(0);
            post.setVoteUp(0);
            postService.save(post);

        } else {
            Post tempPost = postService.getById(post.getId());
            Assert.isTrue(tempPost.getUserId().longValue() == getProfileId().longValue(), "无权限编辑此文章！");

            tempPost.setTitle(post.getTitle());
            tempPost.setContent(post.getContent());
            tempPost.setCategoryId(post.getCategoryId());
            postService.updateById(tempPost);
        }
        return Result.success().action("/post/" + post.getId());
    }
}
