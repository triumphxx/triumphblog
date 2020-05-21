package com.triumphxx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.triumphxx.entity.Post;
import com.triumphxx.vo.CommentVo;
import com.triumphxx.vo.PostVo;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
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

        PostVo postVo = postService.selectOnePost(new QueryWrapper<Post>()
                .eq("p.id", id));
        Assert.notNull(postVo,"文章已经被删除");
        // 1分页，2文章id，3用户id，排序
        IPage<CommentVo> comments = commentService.paging(getPage(), postVo.getId(), null, "created");

        req.setAttribute("post", postVo);
        req.setAttribute("pageData", comments);
        return "post/detail";
    }
}
