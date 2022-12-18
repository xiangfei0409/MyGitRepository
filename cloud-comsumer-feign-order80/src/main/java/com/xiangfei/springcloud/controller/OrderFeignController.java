package com.xiangfei.springcloud.controller;

import com.xiangfei.springcloud.entities.CommonResult;
import com.xiangfei.springcloud.entities.Payment;
import com.xiangfei.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/18 16:30
 */
@RestController
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //open-feign-ribbon,客户端一般默认等待1秒
        return paymentFeignService.paymentFeignTimeout();
    }
}
