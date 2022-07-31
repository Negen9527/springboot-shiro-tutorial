package com.negen.common;

import lombok.Data;

public enum ResponseEnum {
    SUCCESS(0, "成功"),
    ERROR(-1, "失败"),
    ;
    int code;
    String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
