package com.zoe.starfish_server.mapper;

import com.zoe.starfish_server.domain.BookedHouse;
import com.zoe.starfish_server.domain.BookedHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookedHouseMapper {
    long countByExample(BookedHouseExample example);

    int deleteByExample(BookedHouseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BookedHouse record);

    int insertSelective(BookedHouse record);

    List<BookedHouse> selectByExample(BookedHouseExample example);

    BookedHouse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BookedHouse record, @Param("example") BookedHouseExample example);

    int updateByExample(@Param("record") BookedHouse record, @Param("example") BookedHouseExample example);

    int updateByPrimaryKeySelective(BookedHouse record);

    int updateByPrimaryKey(BookedHouse record);
}