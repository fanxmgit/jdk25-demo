package com.niuma.demo.jdk25demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.AbstractHttpServiceRegistrar;

/**
 * @author fanxiaoming
 * @since 2026/1/30 9:35
 */
@Import(HttpExchangeConfig.CustomHttpServiceRegistrar.class)
@Configuration
public class HttpExchangeConfig {

    @Bean
    RestClientHttpServiceGroupConfigurer groupConfigurer() {
        return groups -> {

            groups.filterByName("wx").forEachClient((_, builder) ->
                builder.baseUrl("http://localhost:8080"));

//            groups.filterByName("stackoverflow").forEachClient((_, builder) ->
//                builder.baseUrl("https://api.stackexchange.com?site=stackoverflow"));
        };
    }


    public static class CustomHttpServiceRegistrar extends AbstractHttpServiceRegistrar {

        @Override
        protected void registerHttpServices(GroupRegistry registry, AnnotationMetadata metadata) {
            registry.forGroup("wx").detectInBasePackages("com.niuma.demo.jdk25demo.httpClient.outer.wx");
            // more registrations…
        }
    }

}
