package com.example.cloud.gateway.filters.part;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: JiangYuSong
 * @Date: 2021/7/6 17:51
 *
 * 自定义普通过滤器
 */

@Slf4j
@Component
public class ThreeFilterGatewayFilterFactory extends AbstractGatewayFilterFactory<AbstractGatewayFilterFactory.NameConfig> {

    public ThreeFilterGatewayFilterFactory(){
        super(NameConfig.class);
    }

    @Override
    public GatewayFilter apply(NameConfig config) {

        return ((exchange, chain) -> {
            String uid = exchange.getRequest().getHeaders().getFirst("UID");
            String method = exchange.getRequest().getMethodValue();
            String path = exchange.getRequest().getPath().value();
            log.info("request path: {}, request method: {}, UID: {}", path, method, uid);
            return chain.filter(exchange);
        });
    }

    //过滤器的名称
    @Override
    public String name() {
        return "ThreeFilter";
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("name");
    }

}
