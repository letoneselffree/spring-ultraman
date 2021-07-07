package com.example.cloud.gateway.config;

import com.example.cloud.gateway.filters.bean.OneFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.gateway.filter.factory.rewrite.*;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.web.reactive.function.server.HandlerStrategies;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: JiangYuSong
 * @Date: 2021/7/1 16:17
 */

@Configuration
public class GatewayConfig {

    /**
     * 代码的方式配置路由
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator consumerLocator(RouteLocatorBuilder builder) {
        return builder.routes().route("gateway-two", r -> r.order(-10)
                .path("/gateway/two/**")
                .filters(f -> f.stripPrefix(2).prefixPath("/consumer"))
                .uri("lb://CONSUMER-CLIENT-A")
        ).build();
    }

    @Bean
    public RouteLocator oneFilter(RouteLocatorBuilder builder) {
        return builder.routes().route("one-filter", r -> r
                .path("/gateway/one/**")
                .filters(f -> f.filter(new OneFilter()).stripPrefix(2).prefixPath("/consumer"))
                .uri("lb://CONSUMER-CLIENT-B")
        ).build();
    }

    /**
     * 修改请求body的过滤器工厂
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(ModifyRequestBodyGatewayFilterFactory.class)
    public ModifyRequestBodyGatewayFilterFactory getModifyRequestBodyGatewayFilterFactory() {
        return new ModifyRequestBodyGatewayFilterFactory();
    }

    /**
     * 修改返回body的过滤器工厂
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(ModifyResponseBodyGatewayFilterFactory.class)
    public ModifyResponseBodyGatewayFilterFactory getModifyResponseBodyGatewayFilterFactory() {
        List<HttpMessageReader<?>> messageReaders = HandlerStrategies.withDefaults().messageReaders();
        Set<MessageBodyDecoder> messageBodyDecoders = new HashSet<>();
        Set<MessageBodyEncoder> messageBodyEncoders = new HashSet<>();
        MessageBodyDecoder messageBodyDecoder = new GzipMessageBodyResolver();
        MessageBodyEncoder messageBodyEncoder = new GzipMessageBodyResolver();
        messageBodyDecoders.add(messageBodyDecoder);
        messageBodyEncoders.add(messageBodyEncoder);
        return new ModifyResponseBodyGatewayFilterFactory(messageReaders, messageBodyDecoders, messageBodyEncoders);
    }
}
