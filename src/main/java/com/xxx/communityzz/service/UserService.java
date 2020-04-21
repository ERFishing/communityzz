package com.xxx.communityzz.service;

import com.xxx.communityzz.dao.UserMapper;
import com.xxx.communityzz.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }
}
