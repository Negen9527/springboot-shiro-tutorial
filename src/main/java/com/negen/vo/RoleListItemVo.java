package com.negen.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author ：Negen
 * @date ：2022/8/11 22:01
 * @description：
 */
@Data
public class RoleListItemVo {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    private Integer status;
}
