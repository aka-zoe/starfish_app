package com.zoe.starfish_server;

import com.zoe.starfish_server.config.ApplicationConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ApplicationConfig.class)
@SpringBootApplication
@MapperScan("com.zoe.starfish_server.mapper")
public class StarfishServerApplication implements InitializingBean {

    private final ApplicationConfig config;

    public StarfishServerApplication(ApplicationConfig applicationConfig) {
        this.config = applicationConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(StarfishServerApplication.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("StarfishServerApplication config=" + config.toString());
    }
}
