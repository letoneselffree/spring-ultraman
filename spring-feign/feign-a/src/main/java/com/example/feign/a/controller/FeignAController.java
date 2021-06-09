package com.example.feign.a.controller;

import com.example.feign.a.invoke.ProviderInvoke;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/9 15:47
 *
 *
 * 声明式服务调用
 *
 */

@Slf4j
@RestController
@RequestMapping("/feign")
public class FeignAController {

    @Autowired
    private ProviderInvoke invoke;

    @GetMapping("/talk")
    public String talk(){

        return invoke.supr();
    }
}
