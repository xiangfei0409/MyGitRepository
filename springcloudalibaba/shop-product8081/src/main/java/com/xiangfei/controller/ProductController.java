package com.xiangfei.controller;

import com.alibaba.fastjson.JSON;
import com.xiangfei.domain.Product;
import com.xiangfei.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/21 16:56
 */
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private String serverPort;

    //显示端口
    @GetMapping("/product/lb")
    public String getServerPort(){
        return serverPort;
    }

    //商品信息查询
    @RequestMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid) {
        log.info("接下来要进行商品{}号查询", pid);
        Product product = productService.findByPid(pid);
        log.info("商品信息查询成功，内容为:{}", JSON.toJSONString(product));
        return product;
    }
}
