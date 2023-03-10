package edu.miu.waa.postservice.aspect;

import edu.miu.waa.postservice.domain.dto.request.LoggerRequestDto;
import edu.miu.waa.postservice.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

import static edu.miu.waa.postservice.util.Util.getPrincipalUserName;

@Aspect
@Component
public class LoggerAspect {
    private final LoggerService loggerService;

    @Autowired
    public LoggerAspect(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    @Before("edu.miu.waa.postservice.aspect.AdvicePointcuts.matchAllMethodsOfController()")
    public void logAllMethodCallsAdvice(JoinPoint joinPoint) {
        LoggerRequestDto requestDto = new LoggerRequestDto(0, Instant.now(), getPrincipalUserName(), joinPoint.getSignature().getName());
        loggerService.persistLog(requestDto);
    }
}
