package com.negen.mapper;

import com.negen.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Negen
 * @since 2022-07-30
 */
public interface UserMapper extends BaseMapper<User> {
    User getUserByUsername(@Param("username") String username);

    List<Integer> listAllIds();
}
