package com.example.a.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/10 16:36
 */

@EnableConfigServer
@SpringBootApplication
public class ConfigAApplication {

    public static void main(String[] args){
        SpringApplication.run(ConfigAApplication.class, args);
    }
}
