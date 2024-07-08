package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.News;
import com.zoe.starfish_server.domain.NewsExample;
import com.zoe.starfish_server.mapper.NewsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsService {
    @Resource
    private NewsMapper mapper;

    /**
     * 新增
     *
     * @param news
     * @return
     */
    public boolean insertNews(News news) {
        int insert = mapper.insert(news);
        return insert == 1;
    }

    /**
     * 设置下架
     *
     * @param newsId
     * @return
     */
    public boolean disableNews(Long newsId) {
        News news = mapper.selectByPrimaryKey(newsId);
        if (news != null) {
            //1=正常、-1=隐藏/下架
            news.setStatus(-1);
            int i = mapper.updateByPrimaryKey(news);
            return i == 1;
        }
        return false;
    }

    /**
     * 获取资讯列表：热门或者最新
     *
     * @param hotNews 是否热门资讯
     * @return
     */
    public List<News> newsList(boolean hotNews) {
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        //1=正常、-1=隐藏/下架
        criteria.andStatusEqualTo(1);
        //1=最新咨询、2=热门资讯
        if (hotNews) {
            criteria.andTypeEqualTo(2);
        } else {
            criteria.andTypeEqualTo(1);
        }
        return mapper.selectByExample(example);
    }

    /**
     * 更新资讯内容
     * @param news
     * @return
     */
    public Boolean updateNews(News news) {
        return mapper.updateByPrimaryKey(news) == 1;
    }



}
