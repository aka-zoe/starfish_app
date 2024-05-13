package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.LivingArea;
import com.zoe.starfish_server.mapper.LivingAreaMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 小区服务
 */
@Service
public class LivingAreaService {
    @Resource
    private LivingAreaMapper areaMapper;

    public List<LivingArea> areaList() {
        return areaMapper.selectByExample(null);
    }

    public LivingArea getArea(Long id){
        return areaMapper.selectByPrimaryKey(id);
    }

    public int insertLivingArea(LivingArea livingArea) {
        LivingArea area = areaMapper.selectByPrimaryKey(livingArea.getId());
        if (area != null) {
            return -1;
        }
        return areaMapper.insert(livingArea);
    }

    public int deleteLivingArea(Long id) {
        return areaMapper.deleteByPrimaryKey(id);
    }

    public int updateLivingArea(LivingArea livingArea) {
        return areaMapper.updateByPrimaryKey(livingArea);
    }
}
