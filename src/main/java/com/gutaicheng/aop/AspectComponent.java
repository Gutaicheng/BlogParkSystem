package com.gutaicheng.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * aop组件
 */
@Aspect
@Component
public class AspectComponent {

    @Pointcut("execution(* com.gutaicheng.service.AdminServiceImpl.*(..) )")
    public void pointCut(){
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("(获取参数args的测试)");
        //System.out.println("管理员登陆"+args[0].toString());
        System.out.println("管理员登陆");
        System.out.println("(在切面执行之前):"+ joinPoint.toString());
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after aspect executed(在切面执行之后):"+joinPoint.toString());
    }


    @AfterReturning(pointcut = "pointCut()", returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {
        System.out.println("afterReturning executed, return result is" +
                " (afterReturning执行,返回结果是)"
                + returnVal +joinPoint.toString());
    }



    @AfterThrowing(pointcut = "pointCut()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("(AfterThrowing出错后的报错)error:" + error+"  "+joinPoint.toString());
    }
}

