package com.zoe.starfish_server.mapper;

import com.zoe.starfish_server.domain.HouseResource;
import com.zoe.starfish_server.domain.HouseResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseResourceMapper {
    long countByExample(HouseResourceExample example);

    int deleteByExample(HouseResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HouseResource record);

    int insertSelective(HouseResource record);

    List<HouseResource> selectByExample(HouseResourceExample example);

    HouseResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HouseResource record, @Param("example") HouseResourceExample example);

    int updateByExample(@Param("record") HouseResource record, @Param("example") HouseResourceExample example);

    int updateByPrimaryKeySelective(HouseResource record);

    int updateByPrimaryKey(HouseResource record);
}