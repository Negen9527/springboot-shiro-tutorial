package com.negen.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ：Negen
 * @date ：2022/8/4 22:10
 * @description：
 */
@Data
public class BaseColumn {
    /**
     * 创建时间
     */
    private LocalDateTime createTime = LocalDateTime.now();

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 记录状态  0 正常 1 删除
     */
    private Integer status;
}
