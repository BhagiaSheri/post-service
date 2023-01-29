package edu.miu.waa.postservice.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AdvicePointcuts {
    @Pointcut("@annotation(edu.miu.waa.postservice.aspect.annotation.ExecutionTime)")
    public void matchExecutionTimeAnnotation() {
    }

    @Pointcut("within(edu.miu.waa.postservice.controller..* || edu.miu.waa.postservice.authentication.controller..*)")
    public void matchAllMethodsOfController() {
    }
}
