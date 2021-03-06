package com.triumphxx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.triumphxx.common.lang.Result;
import com.triumphxx.entity.User;
import com.triumphxx.shiro.AccountProfile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 公众号：北漂码农有话说
 * @since 2020-05-10
 */
public interface UserService extends IService<User> {

    Result register(User user);

    AccountProfile login(String username, String valueOf);
}
