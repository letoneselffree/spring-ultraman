package com.example.consul.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: JiangYuSong
 * @Date: 2021/7/7 11:35
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ConsulProviderApplication {

    public static void main(String[] args){
        SpringApplication.run(ConsulProviderApplication.class, args);
    }
}
