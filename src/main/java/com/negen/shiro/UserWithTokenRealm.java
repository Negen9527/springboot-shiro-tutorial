package com.negen.shiro;

import com.negen.entity.User;
import com.negen.service.impl.UserServiceImpl;
import com.negen.utils.JWTToken;
import com.negen.utils.TokenUtil;
import io.jsonwebtoken.Claims;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

public class UserWithTokenRealm extends AuthorizingRealm {
    @Autowired
    UserServiceImpl userService;


    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Claims claims = (Claims) principalCollection.getPrimaryPrincipal();
        String username = claims.getSubject();

        //查询用户的角色和权限 放入 simpleAuthorizationInfo

        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String)authenticationToken.getPrincipal();
        Claims claims = TokenUtil.verify(token);
        return new SimpleAuthenticationInfo(claims,token,getName());
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }
}
