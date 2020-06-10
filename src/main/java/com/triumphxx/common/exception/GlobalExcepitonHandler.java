package com.triumphxx.common.exception;

import com.triumphxx.common.lang.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExcepitonHandler {

    @ExceptionHandler(value = Exception.class)
    public Result handler(HttpServletRequest req, HttpServletResponse resp, Exception e) throws IOException {

//        // ajax 处理
//        String header = req.getHeader("X-Requested-With");
//        if(header != null  && "XMLHttpRequest".equals(header)) {
//            resp.setContentType("application/json;charset=UTF-8");
//            resp.getWriter().print(JSONUtil.toJsonStr(Result.fail(e.getMessage())));
//            return null;
//        }

        if (e instanceof UnknownAccountException) {
            return Result.fail("用户不存在");
        } else if (e instanceof LockedAccountException) {
            return Result.fail("用户被禁用");
        } else if (e instanceof IncorrectCredentialsException) {
            return Result.fail("密码错误");
        } else {
            return Result.fail("用户认证失败");
        }

//        // web处理
//        ModelAndView modelAndView = new ModelAndView("error");
//        modelAndView.addObject("message", e.getMessage());
//        return modelAndView;
    }

}
