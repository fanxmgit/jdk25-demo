package com.niuma.demo.jdk25demo.controller;

import com.niuma.demo.jdk25demo.structuredConcurrency.CouponService;
import com.niuma.demo.jdk25demo.structuredConcurrency.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.StructuredTaskScope;

/**
 * @author fanxiaoming
 * @since 2026/2/24 11:32
 */
@RestController
@RequestMapping("/scope")
public class StructuredConcurrencyController {

    @Resource
    private CouponService couponService;

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/hello")
    public String hello() throws Exception {
        try (var scope = StructuredTaskScope.open()) {
            var couponFuture = scope.fork(() -> couponService.call());
            var orderFuture = scope.fork(() -> orderService.call());
            scope.join();
            return couponFuture.get() + orderFuture.get();
        }
    }

}
