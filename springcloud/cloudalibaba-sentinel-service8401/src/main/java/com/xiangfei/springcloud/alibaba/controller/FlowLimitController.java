package com.xiangfei.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/22 18:02
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "--------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "--------testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
        @RequestParam(value = "p2", required = false) String p2) {
        return "--------testHotKey";
    }

    //自定义异常返回结果blockHandler
    public String deal_testHotKey(String p1, String p2, BlockException blockException) {
        //sentinel默认系统的提示:Blocked by Sentinel(flow limiting)
        return "---------deal_testHotKey,jahaahhaha";
    }
}
