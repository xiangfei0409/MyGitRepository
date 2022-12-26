package com.xiangfei.controller;

import com.alibaba.fastjson.JSON;
import com.xiangfei.domain.Order;
import com.xiangfei.domain.Product;
import com.xiangfei.service.OrderService;
import com.xiangfei.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/21 16:56
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    @Autowired
    ProductService productService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/order/lb")
    public String getServerport(){
        String serverPort = restTemplate.getForObject("http://service-product/product/lb", String.class);
        return serverPort;
    }

    //下单--ribbon实现负载均衡
    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info("接受到{}号商品的下单请求，接下来调用商品微服务查询此商品信息", pid);

        Product product = productService.product(pid);
        log.info("查询到{}号商品的信息，内容是：{}", pid, JSON.toJSONString(product));

        //创建订单
        Order order = new Order();
        order.setUid(1);
        order.setUername("测试用户");
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);

        orderService.create(order);
        log.info("创建订单成功，订单信息为：{}", JSON.toJSONString(order));
        return order;
    }
//    //下单
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接受到{}号商品的下单请求，接下来调用商品微服务查询此商品信息", pid);
//
//        //调用商品微服务查询商品信息
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//        ServiceInstance serviceInstance = instances.get(0);
//
//        Product product = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/" + pid, Product.class);
//        log.info("查询到{}号商品的信息，内容是：{}", pid, JSON.toJSONString(product));
//
//        //创建订单
//        Order order = new Order();
//        order.setUid(1);
//        order.setUername("测试用户");
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//
//        orderService.create(order);
//        log.info("创建订单成功，订单信息为：{}", JSON.toJSONString(order));
//        return order;
//    }
//    //下单
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接受到{}号商品的下单请求，接下来调用商品微服务查询此商品信息", pid);
//
//        //调用商品微服务查询商品信息
//        //一旦服务提供者的地址信息变化了，我们就不得不修改服务调用者的代码
//        Product product = restTemplate.getForObject("http://localhost:8081/product/" + pid, Product.class);
//        log.info("查询到{}号商品的信息，内容是：{}", pid, JSON.toJSONString(product));
//
//        //创建订单
//        Order order = new Order();
//        order.setUid(1);
//        order.setUername("测试用户");
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//
//        orderService.create(order);
//        log.info("创建订单成功，订单信息为：{}", JSON.toJSONString(order));
//        return order;
//    }
}
