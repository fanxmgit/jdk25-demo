package com.niuma.demo.jdk25demo;

/**
 * @author fanxiaoming
 * @since 2026/1/29 15:10
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;

/**
 * @author fanxiaoming
 * @since 2026/1/29 15:10
 */
@RestController
@RequestMapping("/demo")
public class VirtualThreadController {

    private final ExecutorService virtualThreadPool;

    public VirtualThreadController(ExecutorService virtualThreadPool) {
        this.virtualThreadPool = virtualThreadPool;
    }

    @RequestMapping(value = "/hello1")
    public String hello1() {
        // 手动创建虚拟线程，不推荐：1、管理困难 2、线程不复用，有性能损耗
        Thread.ofVirtual().name("virtual-thread-1").start(() -> {
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep((long) (1 + Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return "hello jdk25demo";
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        // 推荐：使用线程池，线程复用，性能好，主要易于管理
        virtualThreadPool.submit(() -> {
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep((long) (1 + Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        virtualThreadPool.submit(() -> {
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep((long) (1 + Math.random() * 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return "hello jdk25demo";
    }
}
