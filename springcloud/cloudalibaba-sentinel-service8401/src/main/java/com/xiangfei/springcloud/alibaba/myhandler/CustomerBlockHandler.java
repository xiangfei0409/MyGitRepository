package com.xiangfei.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiangfei.springcloud.entities.CommonResult;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/23 14:21
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444, "按客户自定义,global handlerException");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444, "按客户自定义,global handlerException2");
    }
}
