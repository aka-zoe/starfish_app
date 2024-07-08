package com.zoe.starfish_server.mapper;

import com.zoe.starfish_server.domain.DianZan;
import com.zoe.starfish_server.domain.DianZanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DianZanMapper {
    long countByExample(DianZanExample example);

    int deleteByExample(DianZanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DianZan record);

    int insertSelective(DianZan record);

    List<DianZan> selectByExample(DianZanExample example);

    DianZan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DianZan record, @Param("example") DianZanExample example);

    int updateByExample(@Param("record") DianZan record, @Param("example") DianZanExample example);

    int updateByPrimaryKeySelective(DianZan record);

    int updateByPrimaryKey(DianZan record);
}