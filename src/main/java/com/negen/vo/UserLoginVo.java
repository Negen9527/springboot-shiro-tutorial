package com.negen.vo;

import lombok.Data;

import java.util.Set;

/**
 * @author ：Negen
 * @date ：2022/7/29 22:00
 * @description：
 */
@Data
public class UserLoginVo {
    String username;
    String token;
    Set<String> roles;
    Set<String> permissions;

}
