package com.example.user.controller;

import com.example.user.model.User;
import com.example.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author：zhuangfei
 * @Description：
 * @Date：14:40 2017/10/30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="添加用户",notes = "使用手机号和密码初始化用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tel",value = "手机号码",required = true,dataType = "String"),
            @ApiImplicitParam(name = "pwd",value = "初始密码",required = true,dataType = "String")
    })
    @PostMapping("/createUser")
    public void createUser(@RequestParam("tel") String tel, @RequestParam("pwd") String pwd) throws Exception{

        userService.createUser(tel,pwd);
    }

    @PostMapping("/createUser2")
    public String createUser2(@Valid User user, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }
        userService.createUser(user.getTel(),user.getPassword());
        return "OK";
    }

    @PutMapping("/updateUser/{id}")
    public void updateUser(@PathVariable("id") String user_id, @RequestParam("nickname") String nickname) throws Exception{

        userService.updateUser(user_id,nickname);
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id) throws Exception {
        return userService.getUser(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("/deleteUser/{id}") Integer id) throws Exception {
        userService.deleteUser(id);
    }
}
