package com.negen.controller;


import com.negen.common.ServerResponse;
import com.negen.dto.AddPermissionDto;
import com.negen.dto.PermissionListDto;
import com.negen.service.impl.PermissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("add")
    public ServerResponse addPermission(@RequestBody AddPermissionDto addPermissionDto) {
        return permissionService.addPermission(addPermissionDto);
    }

    @GetMapping("list")
    public ServerResponse listPermission(PermissionListDto permissionListDto){
        return permissionService.listPermission(permissionListDto);
    }
}
