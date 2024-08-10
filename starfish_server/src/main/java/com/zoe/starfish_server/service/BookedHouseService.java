package com.zoe.starfish_server.service;

import com.zoe.starfish_server.common.resp.BookedListResp;
import com.zoe.starfish_server.domain.BookedHouse;
import com.zoe.starfish_server.domain.BookedHouseExample;
import com.zoe.starfish_server.domain.HouseResource;
import com.zoe.starfish_server.domain.LivingArea;
import com.zoe.starfish_server.mapper.BookedHouseMapper;
import com.zoe.starfish_server.mapper.HouseResourceMapper;
import com.zoe.starfish_server.mapper.LivingAreaMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookedHouseService {
    @Resource
    BookedHouseMapper mapper;

    @Resource
    HouseResourceMapper resourceMapper;

    public Boolean saveBookedHouse(BookedHouse house) {
        return mapper.insert(house) == 1;
    }

    public Boolean updateBookedHouse(BookedHouse house) {
        return mapper.updateByPrimaryKey(house) == 1;
    }

    /**
     * 当前用户的预约记录
     *
     * @param userId
     * @return
     */
    public List<BookedListResp> getBookedHouseList(Long userId) {
        BookedHouseExample example = new BookedHouseExample();
        BookedHouseExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userId);
        List<BookedHouse> bookedHouses = mapper.selectByExample(example);
        if (bookedHouses != null) {
            List<BookedListResp> list = new ArrayList<>();
            for (BookedHouse house : bookedHouses) {
                BookedListResp resp = new BookedListResp();
                resp.setId(house.getId());
                resp.setBookedtime(house.getBookedtime());
                HouseResource resource = resourceMapper.selectByPrimaryKey(house.getHouseresid());
                if (resource != null) {
                    resp.setHouseName(resource.getName());
                }
                //状态（1=待处理、2=超时未处理、3=已处理、4=已关闭）
                resp.setStatus(house.getStatus());
                list.add(resp);
            }
            return list;
        }
        return null;
    }
}
