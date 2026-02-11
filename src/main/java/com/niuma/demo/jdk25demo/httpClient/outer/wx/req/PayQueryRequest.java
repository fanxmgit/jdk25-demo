package com.niuma.demo.jdk25demo.httpClient.outer.wx.req;

import lombok.Getter;
import lombok.Setter;

/**
 * @author fanxiaoming
 * @since 2026/1/30 9:34
 */
@Getter
@Setter
public class PayQueryRequest {
    private String payId;

    public PayQueryRequest(String payId) {
        this.payId = payId;
    }
}
