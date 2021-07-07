package com.example.cloud.gateway.filters.bean;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: JiangYuSong
 * @Date: 2021/7/2 10:59
 *
 * 此类filter不能直接通过配置文件来配置路由，可通过代码配置直接使用。
 * 如果想通过配置文件来配置，需把此过滤器装载进过滤器工厂
 *
 */
@Slf4j
public class OneFilter implements GatewayFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Gateway Filter One, request path:{}", exchange.getRequest().getPath());
        ServerHttpRequest request = exchange.getRequest();
        String method = request.getMethodValue();
        log.info("request method: {}", method);
        if (HttpMethod.GET.name().equalsIgnoreCase(method)){
            String coco = request.getQueryParams().getFirst("coco");
            if (StringUtils.isEmpty(coco) || !coco.equals("ChaoChao")){
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
            log.info("coco is: {}", coco);
        }else if (HttpMethod.POST.name().equalsIgnoreCase(method)){

        }else {
            exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
