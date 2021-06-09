package com.example.feign.a.invoke;

import org.springframework.stereotype.Component;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/9 16:45
 */

@Component
public class InvokeFallBack implements ProviderInvoke{

    @Override
    public String supr() {

        return "No Ultraman";
    }
}
