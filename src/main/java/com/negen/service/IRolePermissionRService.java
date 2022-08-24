package com.negen.service;

import com.negen.common.ServerResponse;
import com.negen.dto.AddRolePermissionRDto;
import com.negen.entity.RolePermissionR;
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
public interface IRolePermissionRService extends IService<RolePermissionR> {

    ServerResponse addRolePermissionR(AddRolePermissionRDto addRolePermissionRDto);
}
