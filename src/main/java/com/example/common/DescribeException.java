package com.example.common;

import com.example.aspect.ExceptionEnum;

/**
 * Created by Liu on 2017/11/7.
 */
public class DescribeException extends RuntimeException {

    private Integer code;

    /**
     * @Author：zhuangfei
     * @Description：继承ExceptionEnum 加入错误状态值
     * @Date：16:14 2017/11/7
     */
    public DescribeException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    /**
     * @Author：zhuangfei
     * @Description：自定义错误信息
     * @Date：16:15 2017/11/7
     */
    public DescribeException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
