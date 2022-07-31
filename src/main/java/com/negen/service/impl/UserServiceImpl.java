package com.negen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.negen.common.ServerResponse;
import com.negen.dto.UserLoginDto;
import com.negen.dto.UserRegisterDto;
import com.negen.entity.User;
import com.negen.mapper.UserMapper;
import com.negen.service.IUserService;
import com.negen.utils.TokenUtil;
import com.negen.vo.UserLoginVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：Negen
 * @date ：2022/7/29 20:58
 * @description：用户业务实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", username);
        return userMapper.selectOne(userQueryWrapper);
    }

    @Override
    public ServerResponse userLogin(UserLoginDto userLoginDto) {
        String username = userLoginDto.getUsername();
        String password = userLoginDto.getPassword();
        User userByUsername = userMapper.getUserByUsername(username);
        if (userByUsername == null) {
            throw new UnknownAccountException();
        }
        if (!userByUsername.getPassword().equals(password)) {
            throw new IncorrectCredentialsException();
        }

        UserLoginVo userLoginVo = new UserLoginVo();
        BeanUtils.copyProperties(userByUsername, userLoginVo);
        String token = TokenUtil.sign(userLoginVo.getUsername());
        userLoginVo.setToken(token);
        return ServerResponse.createBySuccess().data(userLoginVo);
    }

    @Override
    public ServerResponse userRegister(UserRegisterDto userRegisterDto) {
        User user = new User();
        BeanUtils.copyProperties(userRegisterDto, user);
        userMapper.insert(user);
        return ServerResponse.createBySuccess();
    }
}
