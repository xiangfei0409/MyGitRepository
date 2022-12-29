package com.xiangfei.test;

import com.xiangfei.mapper.BrandMapper;
import com.xiangfei.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/29 13:50
 */
public class MybatisTest {

    @Test
    public void testSelectAll() throws IOException {
        //1.获取sqlSessionFactory
        //1.加载mybatis核心配置文件，回去sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        //1.获取sqlSessionFactory
        //1.加载mybatis核心配置文件，回去sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        Brand brands = brandMapper.selectById(1);
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void selectByCondition() throws IOException {
        //接受参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
        Map<String, Object> map = new HashMap<>();
//        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);

        //1.获取sqlSessionFactory
        //1.加载mybatis核心配置文件，回去sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void selectByConditionSingle() throws IOException {
        //接受参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);

        //1.获取sqlSessionFactory
        //1.加载mybatis核心配置文件，回去sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void add() throws IOException {
        //接受参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机，手机中的战斗机";
        int ordered = 100;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1.获取sqlSessionFactory
        //1.加载mybatis核心配置文件，回去sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession  true代表自动提交事务，默认需要手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.add(brand);

        //提交事务
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void add2() throws IOException {
        //接受参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机，手机中的战斗机";
        int ordered = 100;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1.获取sqlSessionFactory
        //1.加载mybatis核心配置文件，回去sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession  true代表自动提交事务，默认需要手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void update() throws IOException {
        //接受参数
        int status = 5;
        String companyName = "波导手机123";
        String brandName = "波导";
        String description = "波导手机，手机中的战斗机";
        int ordered = 200;
        int id = 5;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);
        brand.setId(id);

        //1.获取sqlSessionFactory
        //1.加载mybatis核心配置文件，回去sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession  true代表自动提交事务，默认需要手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        int count = brandMapper.update(brand);
        System.out.println(count);

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void deleteById() throws IOException {
        //接受参数
        int id = 5;

        //1.获取sqlSessionFactory
        //1.加载mybatis核心配置文件，回去sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession  true代表自动提交事务，默认需要手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.deleteById(id);

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void deleteByIds() throws IOException {
        //接受参数
        int[] ids = {6, 7, 8};

        //1.获取sqlSessionFactory
        //1.加载mybatis核心配置文件，回去sqlsessionfactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession  true代表自动提交事务，默认需要手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.deleteByIds(ids);

        //5.释放资源
        sqlSession.close();
    }
}
