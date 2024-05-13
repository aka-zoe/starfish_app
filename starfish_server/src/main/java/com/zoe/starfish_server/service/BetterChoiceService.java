package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.Banner;
import com.zoe.starfish_server.domain.BetterChoice;
import com.zoe.starfish_server.mapper.BetterChoiceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BetterChoiceService {

    @Resource
    BetterChoiceMapper choiceMapper;

    public List<BetterChoice> choiceList() {
        return choiceMapper.selectByExample(null);
    }

    public int insertChoice(BetterChoice choice) {
        BetterChoice betterChoice = choiceMapper.selectByPrimaryKey(choice.getId());
        if (betterChoice != null) {
            return -1;
        }
        return choiceMapper.insert(choice);
    }

    public int deleteChoice(Long id) {
        return choiceMapper.deleteByPrimaryKey(id);
    }

    public int updateChoice(BetterChoice choice) {
        return choiceMapper.updateByPrimaryKey(choice);
    }
}
