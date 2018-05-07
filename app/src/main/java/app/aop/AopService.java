package app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by hasee on 2018/1/2.
 */
@Aspect
@Component
public class AopService {

    @Pointcut("execution(* app.HelloWorld.*(..))")
    public void baffle(){

    }

    @Around("baffle()")
    public String get(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        pjp.proceed();
        return "";
    }

}
