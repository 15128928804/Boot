package com.example.common;

import com.example.aspect.ExceptionEnum;
import com.example.aspect.Result;

/**
 * Created by Liu on 2017/10/31.
 */
public class ResultUtil {

    /**
     * @Author：zhuangfei
     * @Description：
     * @Date：16:13 2017/10/31
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setStatus(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    /**
     * @Author：zhuangfei
     * @Description：提供给部分不需要出参的接口
     * @Date：16:15 2017/10/31
     */
    public static Result success() {
        return success(null);
    }

    /**
     * @Author：zhuangfei
     * @Description：自定义错误信息
     * @Date：16:07 2017/11/7
     */
    public static Result error(Integer code, String msg) {

        Result result = new Result();
        result.setStatus(code);
        result.setData(null);
        result.setMsg(msg);
        return result;
    }

    /**
     * @Author：zhuangfei
     * @Description：返回异常信息，在已知范围内
     * @Date：16:09 2017/11/7
     */
    public static Result error(ExceptionEnum exceptionEnum) {
        Result result = new Result();
        result.setStatus(exceptionEnum.getCode());
        result.setMsg(exceptionEnum.getMsg());
        result.setData(null);
        return result;
    }
}
