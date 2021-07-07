package com.example.consumer.a.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.consumer.a.bean.ChaoChaoBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/say")
    public String say(@RequestBody ChaoChaoBean bean){
        log.info("request body: {}", JSONObject.toJSONString(bean));
        //负载均衡的选出一个provider-service的服务实例
        ServiceInstance instance = client.choose("provider-service");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/provider/super";
        log.info("request url : {}", url);
        return restTemplate.getForObject(url, String.class);
    }
}
