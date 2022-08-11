package com.negen.service.impl;

import com.negen.common.ServerResponse;
import com.negen.dto.AddPermissionDto;
import com.negen.entity.Permission;
import com.negen.mapper.PermissionMapper;
import com.negen.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public ServerResponse addPermission(AddPermissionDto addPermissionDto) {
        Permission permission = new Permission();
        BeanUtils.copyProperties(addPermissionDto, permission);
        permission.setCreateTime(LocalDateTime.now());
        permissionMapper.insert(permission);
        return ServerResponse.createBySuccess();
    }

    @Override
    public List<Integer> listAllIds() {
        return permissionMapper.listAllIds();
    }
}
