package com.example.cloud.gateway.filters.part;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.rewrite.ModifyRequestBodyGatewayFilterFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: JiangYuSong
 * @Date: 2021/7/6 14:36
 *
 * 自定义过滤器-修改请求报文body
 */

@Slf4j
@Component
public class TwoFilterGatewayFilterFactory extends AbstractGatewayFilterFactory<AbstractGatewayFilterFactory.NameConfig> {

    @Autowired
    private ModifyRequestBodyGatewayFilterFactory modifyRequestBodyGatewayFilterFactory;

    public TwoFilterGatewayFilterFactory(){
        super(NameConfig.class);
    }

    @Override
    public GatewayFilter apply(NameConfig config) {
        String name = config.getName();
        log.info("name: {}", name);
        ModifyRequestBodyGatewayFilterFactory.Config modifyConfig = modifyRequestBodyGatewayFilterFactory.newConfig();
        modifyConfig.setRewriteFunction(String.class, String.class, (exchange, body) -> {
            String method = exchange.getRequest().getMethodValue();
            String path = exchange.getRequest().getPath().value();
            log.info("request path: {}, request method: {}", path, method);
            if (method.equalsIgnoreCase(HttpMethod.POST.name())){
                if (StringUtils.isEmpty(body)){
                    log.info("body is null");
                    return Mono.empty();
                }
                log.info("modify request body: {}", body);
                JSONObject modifyBody = JSONObject.parseObject(body);
                modifyBody.put("wife", "Strong ChaoChao");
                return Mono.just(modifyBody.toJSONString());
            }else if (method.equalsIgnoreCase(HttpMethod.GET.name())){
                log.info("Nothing to Nothing: {}", body);
                Map param = exchange.getRequest().getQueryParams();
                log.info("request param: {}", JSONObject.toJSONString(param));
            }
            return Mono.empty();
        });

        return modifyRequestBodyGatewayFilterFactory.apply(modifyConfig);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("name");
    }
}
