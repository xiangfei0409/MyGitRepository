package com.xiangfei.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangfei.springcloud.dao.PaymentDao;
import com.xiangfei.springcloud.entities.Payment;
import com.xiangfei.springcloud.service.PaymentService;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/17 20:02
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentDao.getPaymentById(id);
    }
}
