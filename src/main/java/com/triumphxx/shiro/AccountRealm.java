package com.triumphxx.shiro;

import com.triumphxx.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author:wangyupeng
 * @Date:2020/6/10
 * @Time:8:40
 * @desc:shiro relam
 **/
@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        AccountProfile profile = userService.login(usernamePasswordToken.getUsername(), String.valueOf( usernamePasswordToken.getPassword()));

        SecurityUtils.getSubject().getSession().setAttribute("profile", profile);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(profile, token.getCredentials(), getName());
        return info;
    }
}
