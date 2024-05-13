package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.HouseResource;
import com.zoe.starfish_server.mapper.HouseResourceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 房源服务
 */
@Service
public class HouseResourceService {
    @Resource
    private HouseResourceMapper resourceMapper;

    public List<HouseResource> houseResources() {
        return resourceMapper.selectByExample(null);
    }

    public HouseResource houseResourceDetail(Long id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    public int insertHouseResource(HouseResource houseResource) {
        HouseResource resource = resourceMapper.selectByPrimaryKey(houseResource.getId());
        if (resource != null) {
            return -1;
        }
        return resourceMapper.insert(houseResource);
    }

    public int deleteHouseResource(Long id) {
        return resourceMapper.deleteByPrimaryKey(id);
    }

    public int updateHouseResource(HouseResource houseResource) {
        return resourceMapper.updateByPrimaryKey(houseResource);
    }
}
