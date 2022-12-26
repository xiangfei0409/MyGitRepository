package com.xiangfei.dao;

import com.xiangfei.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: xiangfei
 * @CreateTime: 2022/12/21 16:57
 */
public interface UserDao  extends JpaRepository<User, Integer> {
}
