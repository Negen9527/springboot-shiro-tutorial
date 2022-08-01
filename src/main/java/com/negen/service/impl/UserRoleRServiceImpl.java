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
    public ServerResponse addUserRoleR(List<AddUserRoleRDto> addUserRoleRDtos) {
        List<Integer> userIds = userService.listAllIds();
        List<Integer> roleIds = roleService.listAllIds();
        ArrayList<UserRoleR> userRoleRs = new ArrayList<>();
        if (null == addUserRoleRDtos || addUserRoleRDtos.isEmpty()){
            throw new RuntimeException("addUserRoleRDtos is empty");
        }
        for (int i = 0; i < addUserRoleRDtos.size(); i++) {
            AddUserRoleRDto addUserRoleRDto = addUserRoleRDtos.get(i);
            Integer userId = addUserRoleRDto.getUserId();
            Integer roleId = addUserRoleRDto.getRoleId();
            if (!userIds.contains(userId)){
                throw new RuntimeException("userId is not exist");
            }
            if (!roleIds.contains(roleId)){
                throw new RuntimeException("roleId is not exist");
            }
            UserRoleR userRoleR = new UserRoleR();
            BeanUtils.copyProperties(addUserRoleRDto, userRoleR);
            userRoleRs.add(userRoleR);
        }
        this.saveBatch(userRoleRs);
        return ServerResponse.createBySuccess();
    }
}
