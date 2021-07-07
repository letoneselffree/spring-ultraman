package com.example.consul.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: JiangYuSong
 * @Date: 2021/7/7 14:28
 */

@RestController
@RequestMapping("/provider")
public class ConsulProviderController {

    @GetMapping("/talk")
    public String talk(){
        return "EveryBody say: No Ultraman";
    }
}
