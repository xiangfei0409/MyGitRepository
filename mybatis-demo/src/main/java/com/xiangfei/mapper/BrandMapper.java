package com.xiangfei.mapper;

import com.xiangfei.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/29 13:58
 */
public interface BrandMapper {

    //查询所有
    List<Brand> selectAll();

    //查询详情
    Brand selectById(Integer id);

    //条件查询

    /**
     *  *参数接受
     *      1.散装参数：如果方法中有多个参数，需要使用@Param(“SQL参数占位符名称”)
     *      2.对象参数：对象的属性名称要和参数占位符名称一致
     *      3.map集合参数：sql语句的参数名和map的key的名称对应上
     */
//    List<Brand> selectByCondition(@Param("status") Integer status, @Param("companyName") String companyName, @Param("brandName") String brandName);

//    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    //单条件动态查询
    List<Brand> selectByConditionSingle(Brand brand);

    //新增
    void add(Brand brand);

    //修改
    int update(Brand brand);

    //删除
    void deleteById(int id);

    //批量删除
    void deleteByIds(@Param("ids") int[] ids);

}
