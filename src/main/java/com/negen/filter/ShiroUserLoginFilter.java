package com.negen.filter;

import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author ：Negen
 * @date ：2022/7/29 22:43
 * @description： 未登录过滤器
 */
public class ShiroUserLoginFilter extends UserFilter {
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("{\"code\":\"1\",\"msg\":\"请登录后访问\"}");
    }
}
