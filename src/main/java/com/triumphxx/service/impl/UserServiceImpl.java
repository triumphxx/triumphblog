package com.triumphxx.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.triumphxx.common.lang.Result;
import com.triumphxx.entity.User;
import com.triumphxx.mapper.UserMapper;
import com.triumphxx.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 公众号：北漂码农有话说
 * @since 2020-05-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Result register(User user) {

        int count = this.count(new QueryWrapper<User>()
                .eq("email", user.getEmail())
                .or()
                .eq("username", user.getUsername()));
        if (count>0) return Result.fail("用户名或者邮箱已被占用");

            User temp = new User();
            temp.setUsername(user.getUsername());
            temp.setPassword(SecureUtil.md5(user.getPassword()));
            temp.setEmail(user.getEmail());
            temp.setAvatar("/res/images/avatar/6.jpg");
            temp.setCreated(new Date());
            temp.setPoint(0);
            temp.setVipLevel(0);
            temp.setCommentCount(0);
            temp.setPostCount(0);
            temp.setGender("0");

        this.save(temp);
        return Result.success();
    }
}
