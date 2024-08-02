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
        //解决在调用https接口时报错：javax.net.ssl.SSLHandshakeException：在 Web 服务通信期间握手期间远程主机关闭连接
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        SpringApplication.run(StarfishServerApplication.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("StarfishServerApplication config=" + config.toString());
    }
}
