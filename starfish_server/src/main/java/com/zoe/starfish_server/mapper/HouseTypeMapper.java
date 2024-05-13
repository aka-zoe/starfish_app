package com.zoe.starfish_server.mapper;

import com.zoe.starfish_server.domain.HouseType;
import com.zoe.starfish_server.domain.HouseTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseTypeMapper {
    long countByExample(HouseTypeExample example);

    int deleteByExample(HouseTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HouseType record);

    int insertSelective(HouseType record);

    List<HouseType> selectByExample(HouseTypeExample example);

    HouseType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HouseType record, @Param("example") HouseTypeExample example);

    int updateByExample(@Param("record") HouseType record, @Param("example") HouseTypeExample example);

    int updateByPrimaryKeySelective(HouseType record);

    int updateByPrimaryKey(HouseType record);
}