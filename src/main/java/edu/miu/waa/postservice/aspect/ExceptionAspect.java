package edu.miu.waa.postservice.aspect;

import edu.miu.waa.postservice.domain.dto.request.ExceptionRequestDto;
import edu.miu.waa.postservice.service.ExceptionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

import static edu.miu.waa.postservice.util.Util.getPrincipalUserName;

@Aspect
@Component
public class ExceptionAspect {
    private final ExceptionService exceptionService;

    @Autowired
    public ExceptionAspect(ExceptionService exceptionService) {
        this.exceptionService = exceptionService;
    }

    @AfterThrowing(value = "edu.miu.waa.postservice.aspect.AdvicePointcuts.matchAllMethodsOfController()", throwing = "ex")
    public void logExceptionAdvice(JoinPoint joinPoint, Throwable ex) {
        ExceptionRequestDto requestDto = new ExceptionRequestDto(0, Instant.now(), getPrincipalUserName(), joinPoint.getSignature().getName(), ex.getClass().getName());
        exceptionService.persistException(requestDto);
    }
}
