package com.xiangfei.mybatisplus;

import com.xiangfei.mybatisplus.enums.SexEnum;
import com.xiangfei.mybatisplus.mapper.UserMapper;
import com.xiangfei.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/31 11:11
 */
@SpringBootTest
public class MybatisPlusEnumTest {

    @Resource
    private UserMapper userMapper;

    //通用枚举
    @Test
    public void test(){
        User user = new User();
        user.setName("admin");
        user.setAge(23);
        user.setSex(SexEnum.MALE);
        int result = userMapper.insert(user);
        System.out.println(result);
    }
}
