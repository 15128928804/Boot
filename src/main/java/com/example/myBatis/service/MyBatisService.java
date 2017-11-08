package com.example.myBatis.service;

import com.example.user.model.User;

import java.util.Map;

/**
 * Created by Liu on 2017/11/8.
 */
public interface MyBatisService {

    void createUser(Map<String,Object> reqMap);

    User getUser(Integer id);
}
