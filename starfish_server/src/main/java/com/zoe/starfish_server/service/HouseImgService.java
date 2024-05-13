package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.HouseImg;
import com.zoe.starfish_server.domain.HouseImgExample;
import com.zoe.starfish_server.mapper.HouseImgMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 房源图片服务
 */
@Service
public class HouseImgService {
    @Resource
    private HouseImgMapper imgMapper;

    public HouseImg getImage(Long id){
        return imgMapper.selectByPrimaryKey(id);
    }
    public List<HouseImg> houseImgList() {
        return imgMapper.selectByExample(null);
    }

    public List<HouseImg> imgForHouse(Long houseId) {
        HouseImgExample example = new HouseImgExample();
        HouseImgExample.Criteria criteria = example.createCriteria();
        criteria.andHouseIdEqualTo(houseId);
        return imgMapper.selectByExample(example);
    }

    public int insertHouseImg(HouseImg houseImg) {
        HouseImg img = imgMapper.selectByPrimaryKey(houseImg.getId());
        if (img != null) {
            return -1;
        }
        return imgMapper.insert(houseImg);
    }

    public int deleteHouseImg(Long id) {
        return imgMapper.deleteByPrimaryKey(id);
    }

    public int updateHouseImg(HouseImg houseImg) {
        return imgMapper.updateByPrimaryKey(houseImg);
    }
}
