package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.BookedHouse;
import com.zoe.starfish_server.domain.BookedHouseExample;
import com.zoe.starfish_server.mapper.BookedHouseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookedHouseService {
    @Resource
    BookedHouseMapper mapper;


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
    public List<BookedHouse> getBookedHouseList(Long userId) {
        BookedHouseExample example = new BookedHouseExample();
        BookedHouseExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userId);
        return mapper.selectByExample(example);
    }
}
