package com.negen.dto;

import lombok.Data;

/**
 * @author ：Negen
 * @date ：2022/8/18 22:19
 * @description：
 */
@Data
public class PermissionListDto {
    /**
     * 当前页
     */
    int pageNo;
    /**
     * 每页条数
     */
    int pageSize;
}
