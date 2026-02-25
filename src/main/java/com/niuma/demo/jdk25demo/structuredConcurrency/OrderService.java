package com.niuma.demo.jdk25demo.structuredConcurrency;

import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

/**
 * @author fanxiaoming
 * @since 2026/2/11 17:26
 */
@Component
public class OrderService implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "订单";
    }
}
