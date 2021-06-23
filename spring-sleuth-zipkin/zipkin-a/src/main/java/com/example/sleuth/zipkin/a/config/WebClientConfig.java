package com.example.sleuth.zipkin.a.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/23 15:31
 */

@Configuration
public class WebClientConfig {

    @Autowired
    private ReactorLoadBalancerExchangeFilterFunction lbFunction;

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl("http://sleuth-zipkin-b")
                .filter(lbFunction)
                .build();
    }
}
