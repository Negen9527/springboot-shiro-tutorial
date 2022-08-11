package com.negen.dto;

import lombok.Data;

/**
* @author     ：Negen
* @date       ：2022/8/11 22:03
* @description：
*/
@Data
public class RoleListDto {
    /**
     * 当前页
     */
    int pageNo;
    /**
     * 每页条数
     */
    int pageSize;
}
