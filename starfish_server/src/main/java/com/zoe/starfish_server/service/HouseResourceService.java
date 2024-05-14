package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.HouseResource;
import com.zoe.starfish_server.domain.HouseResourceExample;
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

    public List<HouseResource> houseResources(boolean all) {
        if (all) {
            return resourceMapper.selectByExample(null);
        }
        HouseResourceExample example = new HouseResourceExample();
        HouseResourceExample.Criteria criteria = example.createCriteria();
        //筛选正常状态的房源列表
        criteria.andStatusEqualTo(0);
        return resourceMapper.selectByExample(example);
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
