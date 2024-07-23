package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.Banner;
import com.zoe.starfish_server.domain.BannerExample;
import com.zoe.starfish_server.mapper.BannerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerService {
    @Resource
    private BannerMapper bannerMapper;

    public List<Banner> bannerList() {
        BannerExample example = new BannerExample();
        BannerExample.Criteria criteria = example.createCriteria();
        //状态：0=正常 1=停用 -1=删除
        criteria.andStatusEqualTo(0);
        return bannerMapper.selectByExample(example);
    }

    public int insertBanner(Banner banner) {
        Banner banner1 = bannerMapper.selectByPrimaryKey(banner.getId());
        if (banner1 != null) {
            return -1;
        }
        return bannerMapper.insert(banner);
    }

    public int deleteBanner(Long id) {
        return bannerMapper.deleteByPrimaryKey(id);
    }

    public int updateBanner(Banner banner) {
        return bannerMapper.updateByPrimaryKey(banner);
    }
}
