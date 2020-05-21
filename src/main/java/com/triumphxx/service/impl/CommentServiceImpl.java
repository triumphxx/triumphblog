package com.triumphxx.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.triumphxx.entity.Comment;
import com.triumphxx.mapper.CommentMapper;
import com.triumphxx.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.triumphxx.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 公众号：北漂码农有话说
 * @since 2020-05-10
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public IPage<CommentVo> paging(Page page, Long postId, Long userId, String order) {

        return commentMapper.selectComments(page,new QueryWrapper<Comment>()
                .eq(postId!=null,"post_id",postId)
                .eq(userId!=null,"user_id",userId)
                .orderByDesc(order!=null,order));
    }
}
