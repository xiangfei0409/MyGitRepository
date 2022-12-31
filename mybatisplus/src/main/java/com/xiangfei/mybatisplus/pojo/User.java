package com.xiangfei.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.xiangfei.mybatisplus.enums.SexEnum;
import lombok.Data;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/29 18:44
 */
@Data
//@TableName("t_user")
public class User {

    //将属性所对应的字段指定为主键
    //value属性用于指定主键的字段，实体类的属性id和主键不一样的时候需要用value
    //type设置的是主键生成策略
    @TableId(value = "uid")
    private Long id;
    //指定属性对应的字段名
    @TableField("user_name")
    private String name;
    private Integer age;
    private String email;
    private SexEnum sex;
}
