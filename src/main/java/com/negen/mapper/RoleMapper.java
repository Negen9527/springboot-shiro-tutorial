package com.negen.mapper;

import com.negen.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Negen
 * @since 2022-08-01
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Integer> listAllIds();
}
