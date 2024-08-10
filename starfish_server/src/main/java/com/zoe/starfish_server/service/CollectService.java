package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.Collect;
import com.zoe.starfish_server.domain.CollectExample;
import com.zoe.starfish_server.domain.News;
import com.zoe.starfish_server.domain.NewsExample;
import com.zoe.starfish_server.mapper.CollectMapper;
import com.zoe.starfish_server.mapper.NewsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收藏服务
 */
@Service
public class CollectService {
    @Resource
    private CollectMapper mapper;

    /**
     * 新增
     *
     * @param collect
     * @return
     */
    public boolean insertCollect(Collect collect) {
        int insert = mapper.insert(collect);
        return insert == 1;
    }

    /**
     * 取消收藏
     *
     * @param userId
     * @param type
     * @param houseResId
     * @param newsId
     * @param id
     * @return
     */
    public boolean cancelCollect(Long userId, Integer type, Long houseResId, Long newsId, Long id) {
        //有id的话就直接删
        if (id != null) {
            return mapper.deleteByPrimaryKey(id) == 1;
        }
        CollectExample example = new CollectExample();
        CollectExample.Criteria criteria = example.createCriteria();
        //查分类
        criteria.andCollecttypeEqualTo(type);
        //查用户
        criteria.andUseridEqualTo(userId);
        //查相关id
        if (houseResId != null) {
            criteria.andHouseresidEqualTo(houseResId);
        } else if (newsId != null) {
            criteria.andNewsidEqualTo(newsId);
        }
        List<Collect> collects = mapper.selectByExample(example);
        if (collects != null && collects.size() == 1) {
            Collect collect = collects.get(0);
            return mapper.deleteByPrimaryKey(collect.getId()) == 1;
        }
        return false;
    }

    /**
     * 获取收藏列表
     *
     * @param type 收藏分类：1=房源，2=资讯
     * @return
     */
    public List<Collect> collectList(Long userId, Integer type) {
        if (userId == null) {
            return null;
        }
        CollectExample example = new CollectExample();
        CollectExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userId);
        if (type != null) {
            criteria.andCollecttypeEqualTo(type);
        }
        return mapper.selectByExample(example);
    }
}
