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
    public ServerResponse addRolePermissionR(List<AddRolePermissionRDto> addRolePermissionRDtos) {
        List<Integer> roleIds = roleService.listAllIds();
        List<Integer> permissionIds = permissionService.listAllIds();
        ArrayList<RolePermissionR> rolePermissionRs = new ArrayList<>();
        if (null == addRolePermissionRDtos || addRolePermissionRDtos.isEmpty()){
            throw new RuntimeException("addRolePermissionRDtos is null");
        }
        for (int i = 0; i < addRolePermissionRDtos.size(); i++) {
            AddRolePermissionRDto addRolePermissionRDto = addRolePermissionRDtos.get(i);
            String roleId = addRolePermissionRDto.getRoleId();
            String permissionId = addRolePermissionRDto.getPermissionId();
            if (!roleIds.contains(roleId)){
                throw new RuntimeException("roleId is not exist");
            }
            if (!permissionIds.contains(permissionId)){
                throw new RuntimeException("permissionId is not exist");
            }
            RolePermissionR rolePermissionR = new RolePermissionR();
            BeanUtils.copyProperties(addRolePermissionRDto, rolePermissionR);
            rolePermissionRs.add(rolePermissionR);
        }
        this.saveBatch(rolePermissionRs);
        return ServerResponse.createBySuccess();
    }
}
