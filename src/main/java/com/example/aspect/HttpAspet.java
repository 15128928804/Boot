package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Liu on 2017/11/7.
 */
@Aspect
@Component
public class HttpAspet {

    private static final Logger logger = LoggerFactory.getLogger(HttpAspet.class);

    @Autowired
    private ExceptionHandle exceptionHandle;

    @Pointcut("execution(public * com.example.user.controller.*.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;

        HttpServletRequest request = attributes.getRequest();

        System.out.println(request);
        // url
        logger.info("url:{}", request.getRequestURL());
        // method
        logger.info("method:{}", request.getMethod());
        // ip
        logger.info("ip:{}", request.getRemoteAddr());
        // class_method
        logger.info("class_method:{}", joinPoint.getSignature().getDeclaringTypeName()+","+joinPoint.getSignature().getName());
        // args
        logger.info("arrgs:{}",joinPoint.getArgs());
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Result result = null;

        try{}catch(Exception e){
            return exceptionHandle.exceptionGet(e);
        }

        if(result == null) {
            return proceedingJoinPoint.proceed();
        } else {
            return result;
        }
    }

    @AfterReturning(pointcut = "log()", returning = "object") // 打印输出结果
    public void doAfterReturing(Object object) {
        logger.info("response:", object.toString());
    }
}
