package com.zoe.starfish_server.service;

import com.zoe.starfish_server.common.resp.NewsResp;
import com.zoe.starfish_server.domain.Collect;
import com.zoe.starfish_server.domain.CollectExample;
import com.zoe.starfish_server.domain.News;
import com.zoe.starfish_server.domain.NewsExample;
import com.zoe.starfish_server.mapper.CollectMapper;
import com.zoe.starfish_server.mapper.NewsMapper;
import com.zoe.starfish_server.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class NewsService {
    @Resource
    private NewsMapper mapper;

    @Resource
    private CollectMapper collectMapper;


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
     * 获取资讯列表
     *
     * @param type 1=最新咨询、2=热门资讯、3=雷区、4=行情、5=科普
     * @return
     */
    public List<NewsResp> newsList(Long userId, Integer type) {
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        //1=正常、-1=隐藏/下架
        criteria.andStatusEqualTo(1);
        //1=最新咨询、2=热门资讯、3=雷区、4=行情、5=科普
        if (type != null) {
            //为空就查全部类型
            criteria.andTypeEqualTo(type);
        }
        List<News> newsList = mapper.selectByExample(example);
        List<NewsResp> respList = new ArrayList<>();
        List<Collect> collects = null;
        if (userId != null) {
            //查当前用户下的类型为2的收藏数据
            CollectExample collectExample = new CollectExample();
            CollectExample.Criteria exampleCriteria = collectExample.createCriteria();
            exampleCriteria.andUseridEqualTo(userId);
            exampleCriteria.andCollecttypeEqualTo(2);
            collects = collectMapper.selectByExample(collectExample);
        }

        if (newsList != null && !newsList.isEmpty()) {
            for (News news : newsList) {
                NewsResp newsResp = generateData(news);
                if (userId == null) {
                    newsResp.setCollected(false);
                } else {
                    //判断当前资讯是否已被用户收藏
                    boolean collected = false;
                    for (Collect collect : collects) {
                        if (Objects.equals(collect.getNewsid(), newsResp.getId())) {
                            collected = true;
                        }
                    }
                    newsResp.setCollected(collected);
                }

                respList.add(newsResp);
            }
        }


        return respList;
    }


    /**
     * 更新资讯内容
     *
     * @param news
     * @return
     */
    public Boolean updateNews(News news) {
        return mapper.updateByPrimaryKey(news) == 1;
    }

    /**
     * 点赞
     *
     * @param newsId
     * @param cancel 取消点赞
     * @return
     */
    public Boolean dianZan(Long newsId, Boolean cancel) {
        News news = mapper.selectByPrimaryKey(newsId);
        //获取点赞数
        Long dianzan = news.getDianzan();
        if (dianzan == null) {
            dianzan = 0L;
        }
        if (cancel) {
            //取消点赞
            if (dianzan >= 1) {
                news.setDianzan(dianzan - 1);
            }
        } else {
            news.setDianzan(dianzan + 1);
        }

        return mapper.updateByPrimaryKey(news) == 1;
    }

    public Boolean pingLun(Long newsId) {
        News news = mapper.selectByPrimaryKey(newsId);
        //获取评论数
        Long pinglun = news.getPinglun();
        if (pinglun == null) {
            pinglun = 0L;
        }
        news.setPinglun(pinglun + 1);
        return mapper.updateByPrimaryKey(news) == 1;
    }

    private NewsResp generateData(News news) {
        NewsResp resp = new NewsResp();
        resp.setId(news.getId());
        resp.setContenturl(news.getContenturl());
        resp.setCreatetime(news.getCreatetime());
        resp.setOperationtime(news.getOperationtime());
        resp.setCreateby(news.getCreateby());
        resp.setEditby(news.getEditby());
        resp.setStatus(news.getStatus());
        resp.setTitle(news.getTitle());
        resp.setSubtitle(news.getSubtitle());
        resp.setType(news.getType());
        resp.setTag(news.getTag());
        resp.setDianzan(news.getDianzan());
        resp.setPinglun(news.getPinglun());

        String imageurl = news.getImageurl();
        List<String> imageList = new ArrayList<>();
        if (StringUtils.isEmpty(imageurl)) {
            resp.setImageList(imageList);
        } else {
            boolean contains = imageurl.contains(",");
            if (contains) {
                String[] split = imageurl.split(",");
                imageList = Arrays.asList(split);
            } else {
                imageList.add(imageurl);
            }
        }
        resp.setImageList(imageList);
        return resp;
    }
}
