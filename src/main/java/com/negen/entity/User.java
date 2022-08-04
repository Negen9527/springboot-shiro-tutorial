package com.negen.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author ：Negen
 * @date ：2022/7/29 20:49
 * @description：
 */
@Data
@TableName("user")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends BaseColumn implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;



    /**
     * 最近登录时间
     */
    private LocalDateTime lastLoginTime;

}
