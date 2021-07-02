package com.example.cloud.gateway.filters.global;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @Author: JiangYuSong
 * @Date: 2021/7/2 10:11
 * <p>
 * 全局过滤器，对所有的路由都生效
 */

@Slf4j
@Component
public class ZeroFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put("requestStartTime", System.currentTimeMillis());
        String path = exchange.getRequest().getPath().toString();
        log.info("Global Filter Zero, request path: {}", path);
        String uid = UUID.randomUUID().toString().replace("-", "");
        ServerHttpRequest request = exchange.getRequest().mutate().header("UID", uid).build();
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (StringUtils.isEmpty(token)) {
            log.error("token is null");
            //设置返回响应状态码
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange.mutate().request(request).build()).then(Mono.fromRunnable(() -> {
            //统计耗时
            Long startTime = exchange.getAttribute("requestStartTime");
            if (null != startTime) {
                log.info("request path: {} elapsed time: {}", exchange.getRequest().getURI().getRawPath(), System.currentTimeMillis() - startTime);
            }
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
