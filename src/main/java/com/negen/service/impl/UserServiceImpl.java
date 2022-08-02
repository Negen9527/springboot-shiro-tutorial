package com.negen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.negen.common.ServerResponse;
import com.negen.dto.UserLoginDto;
import com.negen.dto.UserRegisterDto;
import com.negen.entity.User;
import com.negen.mapper.UserMapper;
import com.negen.service.IUserService;
import com.negen.utils.MD5Util;
import com.negen.utils.TokenUtil;
import com.negen.vo.UserInfoVo;
import com.negen.vo.UserLoginVo;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：Negen
 * @date ：2022/7/29 20:58
 * @description：用户业务实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private final String salt = "negen";
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
        password = MD5Util.createPasswd(password, salt);
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
        return ServerResponse.createBySuccess().data(userLoginVo).code(20000);
    }

    @Override
    public ServerResponse userRegister(UserRegisterDto userRegisterDto) {
        User user = new User();
        BeanUtils.copyProperties(userRegisterDto, user);
        String passwd = MD5Util.createPasswd(userRegisterDto.getPassword(), salt);
        user.setPassword(passwd);
        userMapper.insert(user);
        return ServerResponse.createBySuccess();
    }

    @Override
    public List<Integer> listAllIds() {
        return userMapper.listAllIds();
    }

    @Override
    public ServerResponse userInfo(String token) {
        Claims claims = TokenUtil.verify(token);
        String username = claims.getSubject();
        User user = userMapper.getUserByUsername(username);
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        userInfoVo.setName(user.getUsername());
        userInfoVo.setRoles(Arrays.asList("admin"));
        return ServerResponse.createBySuccess().data(userInfoVo).code(20000);
    }
}
