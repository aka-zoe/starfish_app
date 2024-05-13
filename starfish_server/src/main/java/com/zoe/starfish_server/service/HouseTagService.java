package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.HouseTag;
import com.zoe.starfish_server.domain.HouseTagExample;
import com.zoe.starfish_server.mapper.HouseTagMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 房源标签服务
 */
@Service
public class HouseTagService {
    @Resource
    private HouseTagMapper tagMapper;

    public List<HouseTag> allTagList() {
        return tagMapper.selectByExample(null);
    }

    public List<HouseTag> tagListForHouse(Long houseResId) {
        HouseTagExample example = new HouseTagExample();
        HouseTagExample.Criteria criteria = example.createCriteria();
        criteria.andHouseResIdEqualTo(houseResId);
        return tagMapper.selectByExample(example);
    }

    public int insertHouseTag(HouseTag houseTag) {
        HouseTag tag =  tagMapper.selectByPrimaryKey(houseTag.getId());
        if (tag != null) {
            return -1;
        }
        return tagMapper.insert(houseTag);
    }

    public int deleteHouseTag(Long id) {
        return tagMapper.deleteByPrimaryKey(id);
    }

    public int updateHouseTag(HouseTag houseTag) {
        return tagMapper.updateByPrimaryKey(houseTag);
    }
}
