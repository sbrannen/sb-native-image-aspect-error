package org.example.demo.aspect;

import jakarta.validation.constraints.NotNull;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  @Around(
      "within(org.example.demo..*) && execution(public * *(..)) && @target(org.example.demo.aspect.AutomaticLogger)")
  public Object log(@NotNull ProceedingJoinPoint jp) throws Throwable {
    Object result = jp.proceed(jp.getArgs());

    // body removed for simplicity
    return result;
  }
}
