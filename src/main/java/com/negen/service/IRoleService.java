package com.negen.service;

import com.negen.common.ServerResponse;
import com.negen.dto.AddRoleDto;
import com.negen.dto.RoleListDto;
import com.negen.entity.Role;
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
public interface IRoleService extends IService<Role> {

    /**
     * 新增角色
     * @param addRoleDto
     * @return
     */
    ServerResponse addRole(AddRoleDto addRoleDto);

    List<Integer> listAllIds();

    ServerResponse listRole(RoleListDto roleListDto);

    /**
     * 获取角色下的权限 id
     * @param roleId
     * @return
     */
    ServerResponse listByRoleId(Integer roleId);
}
