package com.example.user.service.impl;

import com.example.user.mapper.UserMapper;
import com.example.user.model.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author：zhuangfei
 * @Description：
 * @Date：14:53 2017/10/30
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void createUser(String tel, String pwd) throws Exception {

        userMapper.createUser(tel, pwd);
    }

    @Override
    public void createUser2(String tel, String pwd) throws Exception {
        userMapper.createUser2(tel, pwd);
    }

    @Override
    public void updateUser(String user_id,String nickname) throws Exception {

        userMapper.updateUser(user_id, nickname);
    }

    @Override
    public User getUser(Integer id) throws Exception {
        User user = getUser(id);
        return userMapper.getUser(id);
    }

    @Override
    public void deleteUser(Integer id) throws Exception {

        userMapper.deleteUser(id);
    }
}
