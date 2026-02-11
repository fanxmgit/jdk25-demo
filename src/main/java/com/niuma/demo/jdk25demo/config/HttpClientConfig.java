//package com.niuma.demo.jdk25demo.config;
//
//import com.niuma.demo.jdk25demo.httpClient.outer.wx.PayClient;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestClient;
//import org.springframework.web.client.support.RestClientAdapter;
//import org.springframework.web.service.invoker.HttpServiceProxyFactory;
//
//@Configuration
//// 导入自定义的注册器
//public class HttpClientConfig {
//
//    /**
//     * 配置负载均衡的 RestClient.Builder
//     */
//    /**
//     * 构建 UserHttpInterface 实例
//     */
//    @Bean
//    public PayClient payClient(LoadBalancerInterceptor loadBalancerInterceptor) {
//        RestClient restClient = RestClient.builder()
//            // 添加负载均衡拦截器，用于处理服务发现和负载均衡
//            .requestInterceptor(loadBalancerInterceptor)
//            // 指定服务提供方的应用名称（必须与 Provider 的 spring.application.name 一致）
//            .baseUrl("http://provider-service")
//            .build();
//
//        // 创建 HttpServiceProxyFactory 工厂，用于生成接口代理对象
//        HttpServiceProxyFactory factory = HttpServiceProxyFactory
//            .builderFor(RestClientAdapter.create(restClient))
//            .build();
//
//        // 生成并返回 PayClient 代理对象
//        return factory.createClient(PayClient.class);
//    }
//
//}