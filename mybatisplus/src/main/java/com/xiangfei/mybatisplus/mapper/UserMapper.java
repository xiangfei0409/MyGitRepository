package com.xiangfei.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiangfei.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/29 18:49
 */
public interface UserMapper extends BaseMapper<User> {

    @MapKey("id")
    Map<String,Object> selectMapById(Long id);

    //参数中page对象要在前面
    //通过年龄查询用户信息并分页
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);
}
