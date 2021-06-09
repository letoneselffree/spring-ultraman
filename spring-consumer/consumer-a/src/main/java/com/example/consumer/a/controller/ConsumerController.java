package com.example.consumer.a.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/9 14:22
 *
 * 服务消费者
 *
 *  LoadBalancerClient负载均衡
 *
 */

@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient client;

    @GetMapping("/say")
    public String say(){
        //负载均衡的选出一个provider-service的服务实例
        ServiceInstance instance = client.choose("provider-service");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/provider/super";
        log.info("request url : {}", url);
        return restTemplate.getForObject(url, String.class);
    }
}
