package com.example.provider.a.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/9 13:50
 *
 * 服务提供者
 *
 */


@RestController
@RequestMapping("/provider")
public class ProviderController {

    @GetMapping("/super")
    public String ultraman(){

        return "I say: Ultraman is super man";
    }


}
