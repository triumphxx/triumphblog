package com.triumphxx.vo;

import com.triumphxx.entity.Post;
import lombok.Data;

/**
 * @author:triumphxx
 * @Date:2020/5/10
 * @Time:11:37 下午
 * @desc:首页数据包装类
 **/
@Data
public class PostVo extends Post {

    private Long authorId;
    private String authorName;
    private String authorAvatar;

    private String categoryName;
}
