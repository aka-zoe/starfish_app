package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.DianZan;
import com.zoe.starfish_server.domain.DianZanExample;
import com.zoe.starfish_server.mapper.DianZanMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DianZanService {
    @Resource
    DianZanMapper mapper;

    public Boolean saveDianZan(DianZan dianZan) {
        return mapper.insert(dianZan) == 1;
    }

    /**
     * 取消点赞
     *
     * @param type      1=资讯、2=评论
     * @param newsId    资讯id
     * @param pingLunId 评论id
     * @return
     */
    public Boolean cancel(Integer type, Long newsId, Long pingLunId) {
        Long id = getDianZan(type, newsId, pingLunId).getId();
        //取消点赞
        return mapper.deleteByPrimaryKey(id) == 1;
    }

    public DianZan getDianZan(Integer type, Long newsId, Long pingLunId) {
        DianZanExample example = new DianZanExample();
        DianZanExample.Criteria criteria = example.createCriteria();
        //1=资讯、2=评论
        if (type == 1) {
            criteria.andNewsidEqualTo(newsId);
        } else {
            criteria.andPinglunidEqualTo(pingLunId);
        }
        List<DianZan> dianZans = mapper.selectByExample(example);
        if (dianZans != null && dianZans.size() == 1) {
            return dianZans.get(0);
        }
        return null;
    }
}
