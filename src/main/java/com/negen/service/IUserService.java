package com.negen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.negen.common.ServerResponse;
import com.negen.dto.UserAddDto;
import com.negen.dto.UserLoginDto;
import com.negen.dto.UserRegisterDto;
import com.negen.entity.User;

import java.util.List;

/**
 * @author ：Negen
 * @date ：2022/7/29 20:58
 * @description：
 */
public interface IUserService extends IService<User> {
    public User getUserByUsername(String username);

    ServerResponse userLogin(UserLoginDto userLoginDto);

    /**
     * 账号注册
     * @param userRegisterDto
     * @return
     */
    ServerResponse userRegister(UserRegisterDto userRegisterDto);

    List<Integer> listAllIds();

    ServerResponse userInfo(String token);

    ServerResponse addUser(UserAddDto userAddDto);
}
