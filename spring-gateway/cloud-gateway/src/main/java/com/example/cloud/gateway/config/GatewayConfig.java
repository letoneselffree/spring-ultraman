package com.example.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: JiangYuSong
 * @Date: 2021/7/1 16:17
 */

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator consumerLocator(RouteLocatorBuilder builder) {
        //通过代码配置路由
        return builder.routes().route("gateway-two", r -> r.order(-10)
                .path("/gateway/two/**")
                .filters(f -> f.stripPrefix(2).prefixPath("/consumer"))
                .uri("lb://CONSUMER-CLIENT-A")
        ).build();
    }
}
