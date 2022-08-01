package com.negen.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author ：Negen
 * @date ：2022/8/1 21:33
 * @description：
 */
public class MD5Util {
    /**
     * 密码md5加密
     * @param password 原始密码
     * @param salt 盐
     * @return java.lang.String
     */
    public static String createPasswd(String password,String salt){
        return new Md5Hash(password,salt,2).toString();
    }
}
