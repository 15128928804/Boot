package com.example.myBatis.controller;

import com.example.aspect.ExceptionHandle;
import com.example.aspect.Result;
import com.example.common.ResultUtil;
import com.example.myBatis.service.MyBatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Liu on 2017/11/8.
 */
@RestController
@RequestMapping("/myBatis")
public class MyBatisController {

    @Autowired
    private MyBatisService myBatisService;

    @Autowired
    private ExceptionHandle exceptionHandle;

    @PostMapping("/getUser/{id}")
    public Result getUser(@PathVariable("id") Integer id) {
        Result result = ResultUtil.success();
        try{
            result.setData(myBatisService.getUser(id));
        }catch(Exception e) {
            result = exceptionHandle.exceptionGet(e);
        }
        return result;
    }

    @PostMapping("/createUser")
    public Result createUser(@RequestBody Map<String,Object> reqMap) {
        Result result = ResultUtil.success();
        try{
            myBatisService.createUser(reqMap);
        }catch(Exception e){
            result = exceptionHandle.exceptionGet(e);
        }
        return result;
    }

}
