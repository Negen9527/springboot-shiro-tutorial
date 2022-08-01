package com.negen.controller;


import com.negen.common.ServerResponse;
import com.negen.dto.AddPermissionDto;
import com.negen.service.impl.PermissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Negen
 * @since 2022-08-01
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    PermissionServiceImpl permissionService;

    @PostMapping
    public ServerResponse addPermission(@RequestBody AddPermissionDto addPermissionDto) {
        return permissionService.addPermission(addPermissionDto);
    }
}
