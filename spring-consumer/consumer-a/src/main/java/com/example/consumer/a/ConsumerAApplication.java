package com.example.consumer.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/9 14:14
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerAApplication {

    public static void main(String[] args){
        SpringApplication.run(ConsumerAApplication.class, args);
    }
}
