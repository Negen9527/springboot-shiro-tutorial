package com.negen.dto;

import lombok.Data;

/**
 * @author ：Negen
 * @date ：2022/8/4 21:08
 * @description：
 */
@Data
public class UserListDto {
    /**
     * 当前页
     */
    int pageNo;
    /**
     * 每页条数
     */
    int pageSize;
}
