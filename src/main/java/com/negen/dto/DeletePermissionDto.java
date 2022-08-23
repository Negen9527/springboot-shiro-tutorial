package com.negen.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ：Negen
 * @date ：2022/8/23 21:33
 * @description：
 */
@Data
public class DeletePermissionDto {
    List<Integer> permissionIds;
}
