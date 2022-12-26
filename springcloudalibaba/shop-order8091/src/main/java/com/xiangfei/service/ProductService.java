package com.xiangfei.service;

import com.xiangfei.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/21 19:39
 */
@FeignClient(value = "service-product")
public interface ProductService {

    @RequestMapping("/product/{pid}")
    Product product(@PathVariable("pid") Integer pid);
}
