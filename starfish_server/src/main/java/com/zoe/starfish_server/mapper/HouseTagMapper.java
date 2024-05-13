package com.zoe.starfish_server.mapper;

import com.zoe.starfish_server.domain.HouseTag;
import com.zoe.starfish_server.domain.HouseTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseTagMapper {
    long countByExample(HouseTagExample example);

    int deleteByExample(HouseTagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HouseTag record);

    int insertSelective(HouseTag record);

    List<HouseTag> selectByExample(HouseTagExample example);

    HouseTag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HouseTag record, @Param("example") HouseTagExample example);

    int updateByExample(@Param("record") HouseTag record, @Param("example") HouseTagExample example);

    int updateByPrimaryKeySelective(HouseTag record);

    int updateByPrimaryKey(HouseTag record);
}