package com.example.consumer.b.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/9 15:13
 *
 *
 * 服务消费者
 *
 * Ribbon负载均衡
 *
 */

@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/speak")
    public String speak(){

        String url = "http://provider-service/provider/super";
        return restTemplate.getForObject(url, String.class);
    }
}
