package com.example.user.service.impl;

import com.example.user.controller.UserController;
import com.example.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author：zhuangfei
 * @Description：
 * @Date：15:40 2017/10/30
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    public void createUser() throws Exception {
        /*userService.createUser("000000","000000");
        userService.createUser("000001","000001");
        userService.createUser("000002","000002");
        userService.createUser("000003","000003");
        userService.createUser2("000004","000004");
        userService.createUser2("000005","000005");*/
        userService.createUser2("000008","-10000");
    }

    @Test
    public void updateUser() throws Exception {
    }

    @Test
    public void getUser() throws Exception {
    }

    @Test
    public void deleteUser() throws Exception {
    }

}