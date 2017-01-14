package aop.Advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.event.ObjectChangeListener;

/**
 * Created by Super腾 on 2017/1/5.
 */
@Component
@Aspect
public class Advice {
    //切入点为CodingDaoImpl中的所有方法
    @Pointcut("execution(* aop.dao.impl.CodingDaoImpl.*(..))")
    public void pointcut(){}
    //在这个方法之前进行一些处理
    @Before("pointcut()")
    public void adviceBefore(){
        System.out.println("加载驱动");
        System.out.println("建立连接");
        System.out.println("状态参数");
    }
    @After("pointcut()")
    public void adviceAfter(){
        System.out.println("关闭操作");
    }
    @AfterReturning(returning = "rtv",pointcut = "pointcut()")
    public void adiveAfterReturning(Object rtv){
        System.out.println("目标方法的返回值为"+ rtv+"");
    }
    @Around("pointcut()")
    public int adiveAround(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println("执行方法前--------------");
        pjp.proceed();
        System.out.println("执行方法后--------------");
        return 1;
    }
}
