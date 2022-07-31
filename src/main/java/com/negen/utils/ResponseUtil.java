package com.negen.utils;

import com.negen.common.ServerResponse;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Negen
 * @date ：2022/7/29 21:36
 * @description：
 */
@Component
public class ResponseUtil {
    public void response(HttpServletResponse response, ServerResponse serverResponse) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(serverResponse.toJsonString());
    }
}
