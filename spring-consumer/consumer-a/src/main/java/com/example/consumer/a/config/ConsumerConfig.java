package com.example.consumer.a.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/9 14:19
 */

@Configuration
public class ConsumerConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
