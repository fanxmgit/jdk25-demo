package com.niuma.demo.jdk25demo.controller;

import com.niuma.demo.jdk25demo.httpClient.outer.wx.PayClient;
import com.niuma.demo.jdk25demo.httpClient.outer.wx.req.PayQueryRequest;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanxiaoming
 * @since 2026/1/30 15:32
 */
@RestController
@RequestMapping("/http-exchange")
public class HttpExchangeController {

    @Resource
    private PayClient payClient;

    @RequestMapping("/wx")
    public String wx() {
        return payClient.getPayInfo(new PayQueryRequest("11")).toString();
    }
}
