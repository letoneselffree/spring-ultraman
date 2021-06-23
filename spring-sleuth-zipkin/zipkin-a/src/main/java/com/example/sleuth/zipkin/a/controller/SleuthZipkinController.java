package com.example.sleuth.zipkin.a.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/23 15:37
 */

@Slf4j
@RestController
@RequestMapping("/sleuth")
public class SleuthZipkinController {

    @Autowired
    private WebClient webClient;

    @PostMapping("/zipkin-a")
    public Mono<String> zipkin(){
        log.info("------------->");
        return webClient.post().uri("/sleuth/zipkin-b").retrieve().bodyToMono(String.class);
    }
}
