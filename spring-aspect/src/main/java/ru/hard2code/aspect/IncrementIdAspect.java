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
@Order(1)
@Slf4j
public class IncrementIdAspect {

    @Around("@annotation(ru.hard2code.annotation.Uppercase)")
    public Object invokeIncrementId(ProceedingJoinPoint joinPoint)
            throws Throwable {
        log.info("invokeIncrementId");
        var user = ((User) joinPoint.proceed());
        user.setId(user.getId() == null ? 1L : user.getId() + 1L);
        return user;
    }
}
