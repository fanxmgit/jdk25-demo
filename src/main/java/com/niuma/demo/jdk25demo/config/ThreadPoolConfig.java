package com.niuma.demo.jdk25demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fanxiaoming
 * @since 2026/1/29 16:28
 */
@Configuration
public class ThreadPoolConfig {

    // 改造前：平台线程池
    /*
    @Bean
    public ExecutorService platformThreadPool() {
        return Executors.newFixedThreadPool(20);
    }
    */

    // 改造后：虚拟线程池，业务代码无需任何修改
    @Bean
    public ExecutorService virtualThreadPool() {
        return Executors.newVirtualThreadPerTaskExecutor();
    }
}
