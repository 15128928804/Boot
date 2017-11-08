package com.example.myBatis.service.impl;

import com.example.myBatis.mapper.MyBatisUser;
import com.example.myBatis.service.MyBatisService;
import com.example.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Liu on 2017/11/8.
 */
@Service
public class MyBatisServiceImpl implements MyBatisService {

    @Autowired
    private MyBatisUser myBatisUser;

    @Override
    public void createUser(Map<String, Object> reqMap) {

        myBatisUser.createrUser(reqMap);
    }

    @Override
    public User getUser(Integer id) {
        User user = myBatisUser.getUser(id);
        return user;
    }
}
