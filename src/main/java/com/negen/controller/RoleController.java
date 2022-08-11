package com.negen.controller;


import com.negen.common.ServerResponse;
import com.negen.dto.AddRoleDto;
import com.negen.dto.RoleListDto;
import com.negen.service.impl.RoleServiceImpl;
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
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleServiceImpl roleService;

    @PostMapping("add")
    public ServerResponse addRole(@RequestBody AddRoleDto addRoleDto) {
        return roleService.addRole(addRoleDto);
    }

    @GetMapping("list")
    public ServerResponse listRole(RoleListDto roleListDto){
        return roleService.listRole(roleListDto);
    }
}
