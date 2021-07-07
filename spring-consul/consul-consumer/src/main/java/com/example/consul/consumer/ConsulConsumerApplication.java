package com.example.consul.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: JiangYuSong
 * @Date: 2021/7/7 11:07
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ConsulConsumerApplication {

    public static void main(String[] args){
        SpringApplication.run(ConsulConsumerApplication.class, args);
    }
}
