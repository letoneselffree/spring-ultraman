package com.example.provider.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/7 14:54
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ProviderAApplication {

    public static void main(String[] args){
        SpringApplication.run(ProviderAApplication.class, args);
    }
}
