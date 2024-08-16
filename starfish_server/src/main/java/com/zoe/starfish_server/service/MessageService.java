package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.Message;
import com.zoe.starfish_server.domain.MessageExample;
import com.zoe.starfish_server.mapper.MessageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 消息通知服务
 */
@Service
public class MessageService {
    @Resource
    private MessageMapper mapper;

    public List<Message> getMessages(Long userId, Integer type) {
        MessageExample example = new MessageExample();
        MessageExample.Criteria criteria = example.createCriteria();
        if (userId != null) {
            criteria.andUseridEqualTo(userId);
            if (type != null) {
                criteria.andStatusEqualTo(type);
            }
            return mapper.selectByExample(example);
        } else {
            return null;
        }
    }

    public boolean addMessage(Message message) {
        return mapper.insert(message) == 1;
    }

    public int deleteMessage(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public Message getMessage(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    public boolean updateMessage(Message message) {
        return mapper.updateByPrimaryKey(message) == 1;
    }
}
