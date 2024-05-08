package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.User;
import com.zoe.starfish_server.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> getUserList() {
        return userMapper.selectByExample(null);
    }

    public User getUser(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
