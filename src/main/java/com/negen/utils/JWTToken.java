package com.negen.utils;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author ：Negen
 * @date ：2022/7/31 17:22
 * @description：
 */
public class JWTToken implements AuthenticationToken {
    private String token;
    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
