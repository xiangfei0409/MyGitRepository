package com.xiangfei.service.impl;

import com.xiangfei.dao.OrderDao;
import com.xiangfei.domain.Order;
import com.xiangfei.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/21 16:57
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void create(Order order) {
        orderDao.save(order);
    }
}
