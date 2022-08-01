package com.negen.controller;


import com.negen.common.ServerResponse;
import com.negen.dto.AddRolePermissionRDto;
import com.negen.service.impl.RolePermissionRServiceImpl;
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
@RequestMapping("/role-permission-r")
public class RolePermissionRController {
    @Autowired
    RolePermissionRServiceImpl rolePermissionRService;

    @PostMapping
    public ServerResponse addRolePermissionR(@RequestBody List<AddRolePermissionRDto> addRolePermissionRDtos) {
        return rolePermissionRService.addRolePermissionR(addRolePermissionRDtos);
    }
}
