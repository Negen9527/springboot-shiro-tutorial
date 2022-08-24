package com.negen.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ：Negen
 * @date ：2022/8/1 22:28
 * @description：
 */
@Data
public class AddRolePermissionRDto {
    Integer roleId;
    List<Integer> permissionIds;
}
