package com.xiangfei.service.impl;

import com.xiangfei.dao.ProductDao;
import com.xiangfei.domain.Product;
import com.xiangfei.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/21 16:57
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public Product findByPid(Integer pid){
        return productDao.findById(pid).get();
    }
}
