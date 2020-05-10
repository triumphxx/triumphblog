package com.triumphxx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.triumphxx.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;
import com.triumphxx.vo.PostVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 公众号：北漂码农有话说
 * @since 2020-05-10
 */
public interface PostService extends IService<Post> {

    IPage<PostVo> paging(Page page, Long categoryId, Long userId, Integer level, Boolean recommend, String order);
}
