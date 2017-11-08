package com.example.aspect;

import com.example.common.DescribeException;
import com.example.common.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Liu on 2017/11/7.
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * @Author：zhuangfei
     * @Description：判断是否是已定义的错误，不是则由未知错误代替，记录日志
     * @Date：16:19 2017/11/7
     */
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result exceptionGet(Exception e) {
        if(e instanceof DescribeException) {
            DescribeException MyException = (DescribeException) e;
            return ResultUtil.error(MyException.getCode(), MyException.getMessage());
        }

        logger.error("【系统错误】", e);
        return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
    }

}
