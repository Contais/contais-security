package com.contais.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.web.aspect
 * @date 2018/9/16
 *
 *  切片(类):
 *      1, 切入点(注解)
 *          1.1, 在哪些方法上起作用
 *          1.2, 在什么时候起作用
 *
 *          @before 当切入点之前起作用
 *          @after 当切入点之后起作用
 *          @AfterThrowing : 当切入点抛出异常时起作用
 *          @Around : 包围
 *
 *      2, 增强(方法)
 *          2.1, 起作用时执行的业务逻辑
 *`
 *
 *
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.contais.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("time aspect start..");
        long start = System.currentTimeMillis();

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("arg is " + arg);
        }

        Object proceed = pjp.proceed();

        System.out.println("time filter 耗时: " + (System.currentTimeMillis() - start));
        System.out.println("time aspect end..");

        return proceed;
    }


}
