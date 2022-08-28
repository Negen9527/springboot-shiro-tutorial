package com.negen.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ：Negen
 * @date ：2022/8/1 22:41
 * @description：
 */
@Data
public class AddUserRoleRDto {
    private Integer userId;
    private List<Integer> roleIds;
}
