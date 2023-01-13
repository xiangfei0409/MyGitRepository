package com.xiangfei.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: xiangfei
 * @CreateTime: 2023/1/5 19:34
 */
public class Xianchengchi {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for(int i = 0 ; i < 50 ; i++){
            pool.submit(new ThreadRunner((i + 1)));
        }
        pool.shutdown();
    }
}
