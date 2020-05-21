package com.triumphxx.vo;

import com.triumphxx.entity.Comment;
import lombok.Data;

/**
 * @author:wangyupeng
 * @Date:2020/5/21
 * @Time:12:40
 * @desc:评论和用户信息
 **/
@Data
public class CommentVo extends Comment {
    private Long authorId;
    private String authorName;
    private String authorAvatar;

    private String categoryName;
}
