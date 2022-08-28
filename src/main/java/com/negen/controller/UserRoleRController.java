package com.negen.controller;


import com.negen.common.ServerResponse;
import com.negen.dto.AddUserRoleRDto;
import com.negen.service.impl.UserRoleRServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Negen
 * @since 2022-08-01
 */
@RestController
@RequestMapping("/user-role-r")
public class UserRoleRController {
    @Autowired
    UserRoleRServiceImpl userRoleRService;

    @PostMapping
    public ServerResponse addUserRoleR(@RequestBody AddUserRoleRDto addUserRoleRDto) {
        return userRoleRService.addUserRoleR(addUserRoleRDto);
    }
}
