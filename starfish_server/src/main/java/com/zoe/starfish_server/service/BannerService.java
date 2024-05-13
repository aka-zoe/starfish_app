package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.Banner;
import com.zoe.starfish_server.mapper.BannerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerService {
    @Resource
    private BannerMapper bannerMapper;

    public List<Banner> bannerList() {
        return bannerMapper.selectByExample(null);
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
