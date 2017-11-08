package com.example.user.controller;

import com.example.aspect.ExceptionEnum;
import com.example.aspect.Result;
import com.example.common.ResultUtil;
import com.example.aspect.ExceptionHandle;
import com.example.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Liu on 2017/11/7.
 */
@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ExceptionHandle exceptionHandle;

    @RequestMapping(value="/getResult",method = RequestMethod.POST)
    public Result getResult(@RequestParam("name") String name, @RequestParam("pwd") String pwd) {
        Result result = ResultUtil.success();
        try{
            if(name.equals("礼拜天")) {
                result = ResultUtil.success(new User());
            } else if(name.equals("000")) {
                result = ResultUtil.error(ExceptionEnum.USER_NOT_FIND);
            } else {
                int i = 1/0;
            }
        }catch(Exception e) {
            result = exceptionHandle.exceptionGet(e);
        }
        return result;
    }
}
