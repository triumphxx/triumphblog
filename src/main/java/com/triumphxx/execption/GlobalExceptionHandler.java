package com.triumphxx.execption;

import com.triumphxx.common.lang.Result;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author:wangyupeng
 * @Date:2020/6/10
 * @Time:8:34
 * @desc:全局异常处理
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result doExecption(Exception e){
        if (e instanceof UnknownAccountException) {
            return Result.fail("用户不存在");
        } else if (e instanceof LockedAccountException) {
            return Result.fail("用户被禁用");
        } else if (e instanceof IncorrectCredentialsException) {
            return Result.fail("密码错误");
        } else {
            return Result.fail("用户认证失败");
        }
    }

}
