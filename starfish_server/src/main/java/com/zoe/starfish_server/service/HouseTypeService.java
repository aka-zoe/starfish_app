package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.HouseType;
import com.zoe.starfish_server.mapper.HouseTypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 户型服务
 */
@Service
public class HouseTypeService {
    @Resource
    private HouseTypeMapper typeMapper;

    public List<HouseType> houseTypeList() {
        return typeMapper.selectByExample(null);
    }

    public HouseType getType(Long id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    public int insertHouseType(HouseType houseType) {
        HouseType type = typeMapper.selectByPrimaryKey(houseType.getId());
        if (type != null) {
            return -1;
        }
        return typeMapper.insert(houseType);
    }

    public int deleteHouseType(Long id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    public int updateHouseType(HouseType houseType) {
        return typeMapper.updateByPrimaryKey(houseType);
    }
}
