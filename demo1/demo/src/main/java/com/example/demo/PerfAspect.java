package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    //    @Around("execution(* com.example..*.EventService.*(..))") // 메소드를 감싸는 형태로 적요이 됨
    //위의 방법은 적용을 원치않는 deleteEvent도 적용이 되어버림 이런경우엔 어노테이션으로 활용하는 것이 좋음
//    @Around("@annotation(PerLogging)")
    @Around("bean(simpleEventService)")
    public Object loObject(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }

    @Before("bean(simpleEventService)")
    public void hello() {
        System.out.println("Hello");
    }
}
