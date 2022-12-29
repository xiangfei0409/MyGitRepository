package com.xiangfei;

import com.xiangfei.mapper.UserMapper;
import com.xiangfei.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/28 20:14
 */
public class MybatisDemo2 {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis核心配置文件，回去sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql语句
//        List<User> users = sqlSession.selectList("test.selectAll");
        //3.1获取对应的UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        System.out.println(users);

        //4.释放资源
        sqlSession.close();

    }
}
