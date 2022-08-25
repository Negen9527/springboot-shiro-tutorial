package com.negen.mapper;

import com.negen.entity.RolePermissionR;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Negen
 * @since 2022-08-01
 */
public interface RolePermissionRMapper extends BaseMapper<RolePermissionR> {
    List<Integer> listByRoleId(@Param("roleId") Integer roleId);

    void deleteByRoleId(@Param("roleId") Integer roleId);
}
