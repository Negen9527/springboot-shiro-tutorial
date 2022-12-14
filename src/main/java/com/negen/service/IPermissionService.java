package com.negen.service;

import com.negen.common.ServerResponse;
import com.negen.dto.AddPermissionDto;
import com.negen.dto.DeletePermissionDto;
import com.negen.dto.PermissionListDto;
import com.negen.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Negen
 * @since 2022-08-01
 */
public interface IPermissionService extends IService<Permission> {

    ServerResponse addPermission(AddPermissionDto addPermissionDto);
    List<Integer> listAllIds();

    /**
     * 分页查询权限
     * @param permissionListDto
     * @return
     */
    ServerResponse listPermission(PermissionListDto permissionListDto);

    /**
     * 获取树形结构的权限列表
     * @return
     */
    ServerResponse listTreePermission();

    /**
     * 根据id删除权限信息
     * @return
     */
    ServerResponse deletePermission(DeletePermissionDto deletePermissionDto);
}
