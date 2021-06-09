package com.example.feign.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/9 15:36
 */

@EnableHystrix
@EnableFeignClients
@SpringBootApplication
public class FeignAApplication {

    public static void main(String[] args){
        SpringApplication.run(FeignAApplication.class, args);
    }
}
