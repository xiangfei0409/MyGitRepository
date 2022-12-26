package com.xiangfei.dao;

import com.xiangfei.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/21 16:57
 */
public interface OrderDao extends JpaRepository<Order, Integer> {
}
