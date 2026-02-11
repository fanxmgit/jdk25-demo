package com.niuma.demo.jdk25demo.httpClient.outer.wx;

import com.niuma.demo.jdk25demo.httpClient.outer.wx.req.PayQueryRequest;
import com.niuma.demo.jdk25demo.httpClient.outer.wx.resp.PayQueryResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * @author fanxiaoming
 * @since 2026/1/30 9:24
 */
@HttpExchange("pay")
public interface PayClient {

    /**
     * 查询支付结果
     * @param payQueryRequest 查询支付请求
     * @return 支付结果
     */
    @PostExchange(value = "/query")
    PayQueryResponse getPayInfo(@RequestBody PayQueryRequest payQueryRequest);
}
