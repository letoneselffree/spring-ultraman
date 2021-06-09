package com.example.eureka.c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/9 10:32
 *
 *
 * 注册中心 c
 *
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaCApplication {

    public static void main(String[] args){
        SpringApplication.run(EurekaCApplication.class, args);
    }
}
