package com.qianfeng.distribution.realm;


import com.qianfeng.distribution.user.bean.LoginUserBean;
import com.qianfeng.distribution.user.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    /**
     * 权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        try {
            List<String> funcList = userService.queryFuncByUser(username);
            simpleAuthorizationInfo.addStringPermissions(funcList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        char[] chars = usernamePasswordToken.getPassword();
        String password = new String(chars);

        LoginUserBean userInfo = userService.login(username, password);

        //将登录用户信息保存在Session中
        SecurityUtils.getSubject().getSession().setAttribute("user",userInfo);

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, "AccountRealm");

        return simpleAuthenticationInfo;
    }
}
