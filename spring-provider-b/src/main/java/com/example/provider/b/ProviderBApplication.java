package com.example.provider.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/7 14:57
 */


@EnableDiscoveryClient
@SpringBootApplication
public class ProviderBApplication {

    public static void main(String[] args){
        SpringApplication.run(ProviderBApplication.class, args);
    }
}
