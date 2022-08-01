package com.negen.service.impl;

import com.negen.common.ServerResponse;
import com.negen.dto.AddRoleDto;
import com.negen.entity.Role;
import com.negen.mapper.RoleMapper;
import com.negen.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    @Override
    public ServerResponse addRole(AddRoleDto addRoleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(addRoleDto, role);
        role.setCreateTime(LocalDate.now());
        roleMapper.insert(role);
        return ServerResponse.createBySuccess();
    }

    @Override
    public List<Integer> listAllIds() {
        return roleMapper.listAllIds();
    }

}
