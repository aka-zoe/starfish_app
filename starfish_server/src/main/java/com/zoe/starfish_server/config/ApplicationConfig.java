package com.zoe.starfish_server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;


@ConfigurationProperties("project-info")
@Validated
public class ApplicationConfig {
    private String name;
    private String desc;

    //配置文件中没有读取到的话就用默认值
    private Boolean handsome = Boolean.TRUE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ApplicationConfig{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", handsome=" + handsome +
                '}';
    }
}
