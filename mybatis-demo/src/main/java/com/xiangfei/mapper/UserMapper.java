package com.xiangfei.mapper;

import com.xiangfei.pojo.User;

import java.util.List;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/29 11:45
 */
public interface UserMapper {
    List<User> selectAll();
}
