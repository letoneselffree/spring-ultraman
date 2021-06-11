package com.example.config.c.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/11 10:59
 *
 * 配置刷新
 *
 */

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigController {

    //获取配置文件中的内容
    @Value("${super.hero:error}")
    private String hero;

    @PostMapping("/superHero")
    public Mono<String> superHero(){

        return Mono.justOrEmpty(hero);
    }
}
