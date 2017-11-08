package com.example.user.service;

import com.example.user.model.User;

/**
 * @Author：zhuangfei
 * @Description：
 * @Date：14:52 2017/10/30
 */
public interface UserService {

    void createUser(String tel, String pwd) throws Exception;

    void createUser2(String tel, String password) throws Exception;

    void updateUser(String user_id,String nickname) throws Exception;

    User getUser(Integer id) throws Exception;

    void deleteUser(Integer id) throws Exception;
}
