package com.negen.service.impl;

import com.negen.common.ServerResponse;
import com.negen.dto.AddUserRoleRDto;
import com.negen.entity.Role;
import com.negen.entity.User;
import com.negen.entity.UserRoleR;
import com.negen.mapper.UserRoleRMapper;
import com.negen.service.IUserRoleRService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserRoleRServiceImpl extends ServiceImpl<UserRoleRMapper, UserRoleR> implements IUserRoleRService {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;

    @Override
    public ServerResponse addUserRoleR(AddUserRoleRDto addUserRoleRDto) {
        List<Integer> userIds = userService.listAllIds();
        List<Integer> roleIds = roleService.listAllIds();
        ArrayList<UserRoleR> userRoleRs = new ArrayList<>();
        Integer userId = addUserRoleRDto.getUserId();
        List<Integer> _roleIds = addUserRoleRDto.getRoleIds();
        for (int i = 0; i < _roleIds.size(); i++) {
            Integer roleId = _roleIds.get(i);
            if (!userIds.contains(userId)){
                throw new RuntimeException("userId is not exist");
            }
            if (!roleIds.contains(roleId)){
                throw new RuntimeException("roleId is not exist");
            }
            UserRoleR userRoleR = new UserRoleR();
            userRoleR.setUserId(userId);
            userRoleR.setRoleId(roleId);
            userRoleRs.add(userRoleR);
        }
        this.saveBatch(userRoleRs);
        return ServerResponse.createBySuccess();
    }
}
