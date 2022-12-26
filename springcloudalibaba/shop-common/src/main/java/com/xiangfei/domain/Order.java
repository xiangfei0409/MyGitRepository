package com.xiangfei.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/21 16:37
 */
@Entity(name = "shop_order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;        //订单id

    //用户相关
    private Integer uid;     //用户id
    private String uername;  //用户名

    //商品相关
    private Integer pid;     //商品id
    private String pname;    //商品名称
    private Double pprice;   //商品单价

    //数量
    private Integer number;  //购买数量
}
