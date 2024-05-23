package com.example.spaceships.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.example.spaceships.service.SpaceshipService.getSpaceshipById(..)) && args(id)")
    public void getSpaceshipById(Long id) {}

    @AfterReturning("getSpaceshipById(id)")
    public void logIfNegativeId(Long id) {
        if (id < 0) {
            logger.warn("Request for spaceship with negative id: " + id);
        }
    }
}
