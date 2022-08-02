package com.negen.controller;

import com.negen.common.ServerResponse;
import com.negen.dto.UserLoginDto;
import com.negen.dto.UserRegisterDto;
import com.negen.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：Negen
 * @date ：2022/7/29 21:29
 * @description：
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("login")
    public ServerResponse userLogin(@RequestBody UserLoginDto userLoginDto) {
        return userService.userLogin(userLoginDto);
    }

    @PostMapping("register")
    public ServerResponse userRegister(@RequestBody UserRegisterDto userRegisterDto) {
        return userService.userRegister(userRegisterDto);
    }

    @GetMapping("info")
    public ServerResponse userInfo(@RequestParam("token") String token) {
        return userService.userInfo(token);
    }
}
