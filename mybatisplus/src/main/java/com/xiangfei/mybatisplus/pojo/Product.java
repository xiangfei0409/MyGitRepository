package com.xiangfei.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/31 10:26
 */
@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version//表示乐观锁版本号字段
    private Integer version;
}
