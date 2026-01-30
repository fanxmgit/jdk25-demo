package com.niuma.demo.jdk25demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanxiaoming
 * @since 2026/1/29 17:30
 */
@RestController
@RequestMapping("/version")
public class InterfaceVersionController {

    @RequestMapping(value = "/hello", version = "v1")
    public String hello() {
        return "hello jdk25demo v1";
    }

     @RequestMapping(value = "/hello", version = "v2")
    public String helloV2() {
        return "hello jdk25demo v2";
    }
}
