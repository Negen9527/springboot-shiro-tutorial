package com.negen.exception;

import com.negen.common.ServerResponse;
import com.negen.utils.ResponseUtil;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：Negen
 * @date ：2022/7/29 21:34
 * @description：
 */
@ControllerAdvice
public class GlobalException {
    @Autowired
    ResponseUtil responseUtil;
    //没有权限
    @ExceptionHandler(value = UnauthorizedException.class)
    public void AuthcErrorHandler(HttpServletResponse res, Exception e) throws IOException {
//        responseUtil.response(res,"1","权限不足！"+e.toString());

        responseUtil.response(res, ServerResponse.createByError().msg("没有权限"));
    }

    @ExceptionHandler(value = UnauthenticatedException.class)
    public void unauthenticatedException(HttpServletResponse res, Exception e) throws IOException {
//        responseUtil.response(res,"1","权限不足！"+e.toString());

        responseUtil.response(res, ServerResponse.createByError().msg("没有登录"));
    }

    //未知账号
    @ExceptionHandler(value = UnknownAccountException.class)
    public void UnKnowAccountErrorHandler(HttpServletResponse res, Exception e) throws IOException {
//        myresponse.makeResponse(res,"2","未知账号！"+e.toString());
        responseUtil.response(res, ServerResponse.createByError().msg("未知账号"));
    }


    //凭证异常
    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public void IncorrectCredentialErrorHandler(HttpServletResponse res, Exception e) throws IOException {
//        myresponse.makeResponse(res,"3","凭证异常！"+e.toString());
        responseUtil.response(res, ServerResponse.createByError().msg("凭证异常"));
    }

    //请登录后访问
    @ExceptionHandler(value = AuthorizationException.class)
    public void AuthorizationErrorHandler(HttpServletResponse res, Exception e) throws IOException {
//        myresponse.makeResponse(res,"4","请登录后访问！"+e.toString());
        responseUtil.response(res, ServerResponse.createByError().msg("请登录后访问"));
    }
}
