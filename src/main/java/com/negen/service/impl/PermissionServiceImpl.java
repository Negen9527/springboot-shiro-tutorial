package com.negen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.negen.common.ServerResponse;
import com.negen.dto.AddPermissionDto;
import com.negen.dto.PermissionListDto;
import com.negen.entity.Permission;
import com.negen.mapper.PermissionMapper;
import com.negen.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.negen.utils.List2Tree;
import com.negen.vo.ListTreePermissionVo;
import com.negen.vo.PageListVo;
import com.negen.vo.PermissionListItemVo;
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

    @Override
    public ServerResponse listPermission(PermissionListDto permissionListDto) {
        int pageNo = permissionListDto.getPageNo();
        int pageSize = permissionListDto.getPageSize();
        Page<Permission> permissionPage = new Page<>(pageNo, pageSize);
        Page<Permission> pageResult = permissionMapper.selectPage(permissionPage, null);
        List<Permission> permissions = pageResult.getRecords();
        ArrayList<PermissionListItemVo> permissionListItemVos = new ArrayList<>();
        permissions.forEach(permission -> {
            PermissionListItemVo permissionListItemVo = new PermissionListItemVo();
            BeanUtils.copyProperties(permission, permissionListItemVo);
            permissionListItemVos.add(permissionListItemVo);
        });
        long total = pageResult.getTotal();
        PageListVo<PermissionListItemVo> permissionListItemVoPageListVo = new PageListVo<>();
        permissionListItemVoPageListVo.setTotal(total);
        permissionListItemVoPageListVo.setItems(permissionListItemVos);
        return ServerResponse.createBySuccess().data(permissionListItemVoPageListVo);
    }

    @Override
    public ServerResponse listTreePermission() {
        //查询所有的权限
        List<ListTreePermissionVo> listTreePermissionVos = permissionMapper.listAllPermission();
        List<ListTreePermissionVo> tree = List2Tree.listToTree(listTreePermissionVos);
        return ServerResponse.createBySuccess().data(tree);
    }
}
