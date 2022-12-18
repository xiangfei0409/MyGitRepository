package com.xiangfei.springcloud.service;

import com.xiangfei.springcloud.entities.Payment;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/17 20:01
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(long id);
}
