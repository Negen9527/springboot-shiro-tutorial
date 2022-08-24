package com.negen.service.impl;

import com.negen.common.ServerResponse;
import com.negen.dto.AddRolePermissionRDto;
import com.negen.entity.Permission;
import com.negen.entity.Role;
import com.negen.entity.RolePermissionR;
import com.negen.mapper.PermissionMapper;
import com.negen.mapper.RolePermissionRMapper;
import com.negen.service.IPermissionService;
import com.negen.service.IRolePermissionRService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.negen.service.IRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Negen
 * @since 2022-08-01
 */
@Service
public class RolePermissionRServiceImpl extends ServiceImpl<RolePermissionRMapper, RolePermissionR> implements IRolePermissionRService {
    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    PermissionServiceImpl permissionService;

    @Override
    public ServerResponse addRolePermissionR(AddRolePermissionRDto addRolePermissionRDto) {
        List<Integer> roleIds = roleService.listAllIds();
        List<Integer> permissionIds = permissionService.listAllIds();
        ArrayList<RolePermissionR> rolePermissionRs = new ArrayList<>();
        Integer roleId = addRolePermissionRDto.getRoleId();
        List<Integer> _permissionIds = addRolePermissionRDto.getPermissionIds();
        if (null == _permissionIds || _permissionIds.isEmpty()){
            throw new RuntimeException("permissionIds is null");
        }

        if (!roleIds.contains(roleId)){
            throw new RuntimeException("roleId is not exist");
        }
        for (int i = 0; i < _permissionIds.size(); i++) {
            Integer permissionId = _permissionIds.get(i);
            if (!permissionIds.contains(permissionId)){
                throw new RuntimeException("permissionId is not exist");
            }
            RolePermissionR rolePermissionR = new RolePermissionR();
            rolePermissionR.setRoleId(roleId);
            rolePermissionR.setPermissionId(permissionId);
            rolePermissionRs.add(rolePermissionR);
        }
        this.saveBatch(rolePermissionRs);
        return ServerResponse.createBySuccess();
    }
}
