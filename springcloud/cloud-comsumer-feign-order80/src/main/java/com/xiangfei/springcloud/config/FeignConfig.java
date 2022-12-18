package com.xiangfei.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/18 17:17
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level fergnLoggerLevel(){
        return Logger.Level.FULL;
    }
}
