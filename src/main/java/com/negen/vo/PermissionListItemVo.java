package com.negen.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ：Negen
 * @date ：2022/8/18 22:22
 * @description：
 */
@Data
public class PermissionListItemVo {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 权限名
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    private Integer status;
}
