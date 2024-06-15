package com.zoe.starfish_server.mapper;

import com.zoe.starfish_server.domain.LivingArea;
import com.zoe.starfish_server.domain.LivingAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LivingAreaMapper {
    long countByExample(LivingAreaExample example);

    int deleteByExample(LivingAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LivingArea record);

    int insertSelective(LivingArea record);

    List<LivingArea> selectByExample(LivingAreaExample example);

    LivingArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LivingArea record, @Param("example") LivingAreaExample example);

    int updateByExample(@Param("record") LivingArea record, @Param("example") LivingAreaExample example);

    int updateByPrimaryKeySelective(LivingArea record);

    int updateByPrimaryKey(LivingArea record);
}