package com.negen.filter;

import com.negen.common.ServerResponse;
import com.negen.utils.JWTToken;
import com.negen.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：Negen
 * @date ：2022/7/31 17:19
 * @description：
 */
@Slf4j
public class JWTFilter extends AccessControlFilter {
    // 登录标识
    private static String LOGIN_SIGN = "token";
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        //使用token登陆
        try {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            String authorization = req.getHeader(LOGIN_SIGN);
            JWTToken token = new JWTToken(authorization);
            // 提交给realm进行登入，如果错误他会抛出异常并被捕获
            getSubject(servletRequest, servletResponse).login(token);
        }catch (AuthenticationException e){
            new ResponseUtil()
                    .response((HttpServletResponse) servletResponse,
                            ServerResponse.createByError().msg("请登录后访问"));
            return false;
        }
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }
}
