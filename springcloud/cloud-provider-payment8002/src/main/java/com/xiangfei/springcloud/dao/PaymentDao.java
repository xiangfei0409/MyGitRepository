package com.xiangfei.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xiangfei.springcloud.entities.Payment;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/17 19:50
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") long id);
}
