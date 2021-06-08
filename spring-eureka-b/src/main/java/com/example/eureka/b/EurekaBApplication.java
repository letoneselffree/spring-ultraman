package com.example.eureka.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/7 15:38
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaBApplication {

    public static void main(String[] args){
        SpringApplication.run(EurekaBApplication.class, args);
    }
}
