package com.zoe.starfish_server.mapper;

import com.zoe.starfish_server.domain.PingLun;
import com.zoe.starfish_server.domain.PingLunExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PingLunMapper {
    long countByExample(PingLunExample example);

    int deleteByExample(PingLunExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PingLun record);

    int insertSelective(PingLun record);

    List<PingLun> selectByExample(PingLunExample example);

    PingLun selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PingLun record, @Param("example") PingLunExample example);

    int updateByExample(@Param("record") PingLun record, @Param("example") PingLunExample example);

    int updateByPrimaryKeySelective(PingLun record);

    int updateByPrimaryKey(PingLun record);
}