package com.zoe.starfish_server.mapper;

import com.zoe.starfish_server.domain.BetterChoice;
import com.zoe.starfish_server.domain.BetterChoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BetterChoiceMapper {
    long countByExample(BetterChoiceExample example);

    int deleteByExample(BetterChoiceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BetterChoice record);

    int insertSelective(BetterChoice record);

    List<BetterChoice> selectByExample(BetterChoiceExample example);

    BetterChoice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BetterChoice record, @Param("example") BetterChoiceExample example);

    int updateByExample(@Param("record") BetterChoice record, @Param("example") BetterChoiceExample example);

    int updateByPrimaryKeySelective(BetterChoice record);

    int updateByPrimaryKey(BetterChoice record);
}