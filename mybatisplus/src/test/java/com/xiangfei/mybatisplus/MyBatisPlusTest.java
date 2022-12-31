package com.xiangfei.mybatisplus;

import com.xiangfei.mybatisplus.mapper.UserMapper;
import com.xiangfei.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/29 18:54
 */
@SpringBootTest
public class MyBatisPlusTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        //通过条件构造器查询一个list集合，若没有条件，则可设置null为参数
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        //新增用户信息
        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@xiangfei.com");
        int result = userMapper.insert(user);
        System.out.println("result:" + result);
        System.out.println("id:" + user.getId());
    }

    @Test
    public void testDelete() {
        //根据id删除
//        int result = userMapper.deleteById(1608420802895507457L);
//        System.out.println(result);
        //根据map删除
//        Map<String, Object> map = new HashMap<>();
//        map.put("name","张三");
//        map.put("age",23);
//        userMapper.deleteByMap(map);
        //通过多个ID实现批量删除
        List<Long> list = Arrays.asList(1608422980473229314L, 1608423552232374274L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println(result);
    }

    @Test
    public void testUpdate() {
        //UPDATE user SET name=?, email=? WHERE id=?
        User user = new User();
        user.setId(1L);
        user.setName("任向飞");
        user.setEmail("123@qq.com");
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    @Test
    public void testSelect() {
        //通过id查询用户信息
        //SELECT id,name,age,email FROM user WHERE id=?
//        User user = userMapper.selectById(1L);
//        System.out.println(user);

        //根据多个id查询多个用户信息
        //SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        List<Long> list = Arrays.asList(1l, 2l, 3l);
        List<User> users = userMapper.selectBatchIds(list);
        System.out.println(users);

        //根据map查询
        //SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
//        Map<String, Object> map = new HashMap<>();
//        map.put("name","Jack");
//        map.put("age","20");
//        List<User> users1 = userMapper.selectByMap(map);
//        System.out.println(users1);

        //自定义查询
        Map<String, Object> stringObjectMap = userMapper.selectMapById(1L);
        System.out.println(stringObjectMap);
    }
}
