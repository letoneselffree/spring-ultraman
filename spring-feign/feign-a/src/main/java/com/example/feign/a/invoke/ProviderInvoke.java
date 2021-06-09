package com.example.feign.a.invoke;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/9 15:43
 *
 * @FeignClient注解来指定这个接口所要调用的服务名称
 *
 * 注意：如果是调用的服务是get请求并携带有参数，
 * 则此处传参的时候需加@RequestParam注解
 *
 */

@FeignClient(name = "provider-service", fallback = InvokeFallBack.class)
public interface ProviderInvoke {

    //服务中的接口请求路径
    @GetMapping("/provider/super")
    public String supr();
}
