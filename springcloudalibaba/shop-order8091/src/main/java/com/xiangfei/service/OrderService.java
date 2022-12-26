package com.xiangfei.service;

import com.xiangfei.domain.Order;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/21 16:57
 */
public interface OrderService {

    //创建订单
    public void create(Order order);
}
