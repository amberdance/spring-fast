package ru.hard2code.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.hard2code.model.User;


@Component
@Aspect
@Order(2)
@Slf4j
public class UppercaseNameAspect {

    @Around("@annotation(ru.hard2code.annotation.Uppercase)")
    @Order(1)
    public Object invokeAroundUppercase(ProceedingJoinPoint joinPoint)
            throws Throwable {
        log.info("invokeAroundUppercase");
        var user = ((User) joinPoint.proceed());
        user.setName(user.getName().toUpperCase());
        return user;
    }

}
