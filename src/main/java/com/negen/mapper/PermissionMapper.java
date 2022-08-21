package com.negen.mapper;

import com.negen.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.negen.vo.ListTreePermissionVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Negen
 * @since 2022-08-01
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Integer> listAllIds();

    List<ListTreePermissionVo> listAllPermission();
}
