package com.example.sleuth.zipkin.b.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/23 15:49
 */

@Slf4j
@RestController
@RequestMapping("/sleuth")
public class SleuthZipkinController {

    @PostMapping("/zipkin-b")
    public Mono<String> zipkin(){
        log.info("--------------->{}", "zipkin-b");

        return Mono.just("Ultraman, Oh yeah!");
    }
}
