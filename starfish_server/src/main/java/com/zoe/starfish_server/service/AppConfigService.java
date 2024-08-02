package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.AppConfig;
import com.zoe.starfish_server.domain.Banner;
import com.zoe.starfish_server.domain.BannerExample;
import com.zoe.starfish_server.mapper.AppConfigMapper;
import com.zoe.starfish_server.mapper.BannerMapper;
import com.zoe.starfish_server.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppConfigService {
    @Resource
    private AppConfigMapper mapper;

    public AppConfig getConfig(){
        List<AppConfig> appConfigs = configList();
        if(appConfigs == null || appConfigs.isEmpty()){
            return null;
        }
        return appConfigs.get(0);
    }
    public List<AppConfig> configList() {
        return mapper.selectByExample(null);
    }

    public boolean insertOrUpdateBanner(AppConfig config) {
        List<AppConfig> appConfigs = configList();
        if (appConfigs == null || appConfigs.isEmpty()) {
            //没有，插入
            return mapper.insert(config) == 1;
        } else {
            //已有，更新
            AppConfig appConfig = appConfigs.get(0);
            if (StringUtils.isNotEmpty(config.getUmAppKey())) {
                appConfig.setUmAppKey(config.getUmAppKey());
            }
            if (StringUtils.isNotEmpty(config.getUmAppMasterSecret())) {
                appConfig.setUmAppMasterSecret(config.getUmAppMasterSecret());
            }
            if (StringUtils.isNotEmpty(config.getUmHost())) {
                appConfig.setUmHost(config.getUmHost());
            }

            return mapper.updateByPrimaryKey(appConfig) == 1;
        }
    }

}
