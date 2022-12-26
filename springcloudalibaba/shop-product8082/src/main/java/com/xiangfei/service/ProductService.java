package com.xiangfei.service;

import com.xiangfei.domain.Product;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/21 16:57
 */
public interface ProductService {

    Product findByPid(Integer pid);
}
