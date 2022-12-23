package com.xiangfei.springcloud.alibaba.service;

import com.xiangfei.springcloud.entities.CommonResult;
import com.xiangfei.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/23 16:00
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回， ---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
