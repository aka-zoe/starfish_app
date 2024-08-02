package com.zoe.starfish_server.mapper;

import com.zoe.starfish_server.domain.AppConfig;
import com.zoe.starfish_server.domain.AppConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppConfigMapper {
    long countByExample(AppConfigExample example);

    int deleteByExample(AppConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppConfig record);

    int insertSelective(AppConfig record);

    List<AppConfig> selectByExample(AppConfigExample example);

    AppConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppConfig record, @Param("example") AppConfigExample example);

    int updateByExample(@Param("record") AppConfig record, @Param("example") AppConfigExample example);

    int updateByPrimaryKeySelective(AppConfig record);

    int updateByPrimaryKey(AppConfig record);
}