package com.negen.common;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author ：Negen
 * @date ：2022/7/29 20:59
 * @description：
 */
@Data
public class ServerResponse {
    private int code;
    private String msg;
    private Object data;

    ServerResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ServerResponse(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
    }

    public static ServerResponse createBySuccess() {
        return new ServerResponse(ResponseEnum.SUCCESS);
    }

    public static ServerResponse createByError() {
        return new ServerResponse(ResponseEnum.ERROR);
    }

    public ServerResponse code(int code) {
        this.code = code;
        return this;
    }

    public ServerResponse msg(String msg) {
        this.msg = msg;
        return this;
    }

    public ServerResponse data(Object data) {
        this.data = data;
        return this;
    }

    public ServerResponse responseEnum(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
        return this;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }
}
