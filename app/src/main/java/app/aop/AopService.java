package app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by hasee on 2018/1/2.
 */
@Aspect
@Component
public class AopService {

    @Around("execution(* app.HelloWorld.index())")
    public String get(ProceedingJoinPoint pjp){
        System.out.println("aop executed!");
        return "yy";
    }

}
