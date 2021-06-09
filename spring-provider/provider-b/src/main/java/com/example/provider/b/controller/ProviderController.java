package com.example.provider.b.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/9 14:07
 *
 *
 * 服务提供者
 *
 */

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @GetMapping("/super")
    public String ultraman(){

        return "ChaoChao say: Ultraman is super women!";
    }
}
