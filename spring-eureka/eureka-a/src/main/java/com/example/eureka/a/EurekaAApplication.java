package com.example.eureka.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/7 13:56
 *
 * 注册中心 a
 *
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaAApplication {

    public static void main(String[] args){
        SpringApplication.run(EurekaAApplication.class, args);
    }
}
