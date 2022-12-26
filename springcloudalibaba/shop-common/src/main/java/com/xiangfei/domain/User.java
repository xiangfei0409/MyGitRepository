package com.xiangfei.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/21 16:23
 */
//用户
@Entity(name = "shop_user")  //实体类跟表相对应
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;     //主键
    private String username; //用户名
    private String password; //密码
    private String telephone;//手机号
}
