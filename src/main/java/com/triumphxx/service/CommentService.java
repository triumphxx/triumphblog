package com.triumphxx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.triumphxx.entity.Comment;
import com.triumphxx.vo.CommentVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 公众号：北漂码农有话说
 * @since 2020-05-10
 */
public interface CommentService extends IService<Comment> {
    /**
     * 查询文章的评论列表
     * 带上一壶的信息
     * @param page
     * @param postId
     * @param userId
     * @param order
     * @return
     */
    IPage<CommentVo> paging(Page page, Long postId, Long userId, String order);
}
