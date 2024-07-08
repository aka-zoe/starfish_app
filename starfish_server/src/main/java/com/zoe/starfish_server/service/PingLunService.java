package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.PingLun;
import com.zoe.starfish_server.mapper.PingLunMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PingLunService {

    @Resource
    PingLunMapper mapper;

    public Boolean savePingLun(PingLun pingLun) {
        return mapper.insert(pingLun) == 1;
    }

    public Boolean update(PingLun pingLun) {
        return mapper.updateByPrimaryKey(pingLun) == 1;
    }

    /**
     * 点赞/取消点赞
     *
     * @param id
     * @param cancel
     * @return
     */
    public Boolean dianZan(Long id, Boolean cancel) {
        PingLun pingLun = mapper.selectByPrimaryKey(id);
        Long dianzan = pingLun.getDianzan();
        if (cancel) {
            if (dianzan >= 1) {
                pingLun.setDianzan(dianzan - 1);
            }
        } else {
            pingLun.setDianzan(dianzan + 1);
        }
        return update(pingLun);
    }
}
