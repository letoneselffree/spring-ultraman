package com.example.a.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author: JiangYuSong
 * @Date: 2021/6/10 16:36
 *
 * 配置中心服务端
 *
 * http://localhost:9051/config/dev
 * http://localhost:9051/config-dev.yml
 * 仓库中的配置文件会被转换成 Web 接口，访问可以参照以下的规则：
 *
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 *
 * 上面的 URL 会映射{application}-{profile}.yml对应的配置文件，
 * 其中{label}对应 Git 上不同的分支，默认为 master。以 config-dev.yml 为例子，
 * 它的 application 是 config，profile 是 dev。
 *
 */

@EnableConfigServer
@SpringBootApplication
public class ConfigAApplication {

    public static void main(String[] args){
        SpringApplication.run(ConfigAApplication.class, args);
    }
}
