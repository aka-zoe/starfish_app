package com.zoe.starfish_server.service;

import com.zoe.starfish_server.domain.User;
import com.zoe.starfish_server.domain.UserExample;
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

    /**
     * 检查已存在用户
     *
     * @param name
     * @return
     */
    public List<User> checkExistUser(String name, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        return users;
    }

    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    public int insertUser(User user) {
        return userMapper.insert(user);
    }
}
