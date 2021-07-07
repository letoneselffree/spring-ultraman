package com.example.consul.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: JiangYuSong
 * @Date: 2021/7/7 14:23
 */

@Configuration
public class ConsulConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
