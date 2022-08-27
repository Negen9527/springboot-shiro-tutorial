package com.negen.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.negen.common.ServerResponse;
import com.negen.dto.AddRoleDto;
import com.negen.dto.RoleListDto;
import com.negen.entity.Role;
import com.negen.mapper.RoleMapper;
import com.negen.mapper.RolePermissionRMapper;
import com.negen.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.negen.vo.ListRoleTreeVo;
import com.negen.vo.PageListVo;
import com.negen.vo.RoleListItemVo;
import com.negen.vo.UserListItemVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RolePermissionRMapper rolePermissionRMapper;
    @Override
    public ServerResponse addRole(AddRoleDto addRoleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(addRoleDto, role);
        role.setCreateTime(LocalDateTime.now());
        roleMapper.insert(role);
        return ServerResponse.createBySuccess();
    }

    @Override
    public List<Integer> listAllIds() {
        return roleMapper.listAllIds();
    }

    @Override
    public ServerResponse listRole(RoleListDto roleListDto) {
        int pageSize = roleListDto.getPageSize();
        int pageNo = roleListDto.getPageNo();
        Page<Role> rolePage = new Page<>(pageNo, pageSize);
        Page<Role> rolePageResult = roleMapper.selectPage(rolePage, null);
        List<Role> roles = rolePageResult.getRecords();
        long total = rolePageResult.getTotal();
        ArrayList<RoleListItemVo> userListItemVos = new ArrayList<>();
        roles.forEach(role -> {
            RoleListItemVo roleListItemVo = new RoleListItemVo();
            BeanUtils.copyProperties(role, roleListItemVo);
            userListItemVos.add(roleListItemVo);
        });
        PageListVo<RoleListItemVo> roleListItemVoPageListVo = new PageListVo<>();
        roleListItemVoPageListVo.setItems(userListItemVos);
        roleListItemVoPageListVo.setTotal(total);
        return ServerResponse.createBySuccess().data(roleListItemVoPageListVo);
    }

    @Override
    public ServerResponse listByRoleId(Integer roleId) {
        List<Integer> permissionIds = rolePermissionRMapper.listByRoleId(roleId);
        if (permissionIds == null)permissionIds = new ArrayList<>();
        return ServerResponse.createBySuccess().data(permissionIds);
    }

    @Override
    public ServerResponse listRoleTree() {
        List<ListRoleTreeVo> listRoleTreeVos = roleMapper.getListTree();
        if (null == listRoleTreeVos) listRoleTreeVos = new ArrayList<>();
        return ServerResponse.createBySuccess().data(listRoleTreeVos);
    }

}
