package com.example.consul.consumer.controller;

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
 * @Date: 2021/7/7 14:17
 */

@Slf4j
@RestController
@RequestMapping("/consul")
public class ConsulConsumerController {

    @Autowired
    private LoadBalancerClient client;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/talk")
    public String talk(){

        ServiceInstance instance = client.choose("consul-provider");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/provider/talk";
        log.info("request url : {}", url);
        return restTemplate.getForObject(url, String.class);
    }
}
