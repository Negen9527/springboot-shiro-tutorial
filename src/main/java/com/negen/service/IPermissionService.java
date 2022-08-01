package com.negen.service;

import com.negen.common.ServerResponse;
import com.negen.dto.AddPermissionDto;
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
}
