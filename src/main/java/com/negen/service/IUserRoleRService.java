package com.negen.service;

import com.negen.common.ServerResponse;
import com.negen.dto.AddUserRoleRDto;
import com.negen.entity.UserRoleR;
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
public interface IUserRoleRService extends IService<UserRoleR> {

    ServerResponse addUserRoleR(List<AddUserRoleRDto> addUserRoleRDtos);
}
