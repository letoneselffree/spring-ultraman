package com.example.consumer.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/9 15:19
 *
 * Finchley.RC1及以上的spring-cloud
 * 已经无需添加@EnableDiscoveryClient注解了
 *
 */

@SpringBootApplication
public class ConsumerBApplication {

    public static void main(String[] args){
        SpringApplication.run(ConsumerBApplication.class, args);
    }
}
