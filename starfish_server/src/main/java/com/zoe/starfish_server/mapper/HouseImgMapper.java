package com.zoe.starfish_server.mapper;

import com.zoe.starfish_server.domain.HouseImg;
import com.zoe.starfish_server.domain.HouseImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseImgMapper {
    long countByExample(HouseImgExample example);

    int deleteByExample(HouseImgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HouseImg record);

    int insertSelective(HouseImg record);

    List<HouseImg> selectByExample(HouseImgExample example);

    HouseImg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HouseImg record, @Param("example") HouseImgExample example);

    int updateByExample(@Param("record") HouseImg record, @Param("example") HouseImgExample example);

    int updateByPrimaryKeySelective(HouseImg record);

    int updateByPrimaryKey(HouseImg record);
}